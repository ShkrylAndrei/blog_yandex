package info.examples.process_different_type_files;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Сервис для обработки файлов.
 *
 * Является синглтоном (по умолчанию), но создаёт новые экземпляры
 * обработчиков для каждого файла через фабрику.
 */
@Slf4j
@Service
public class FileProcessorService {

    private final FileProcessorFactory processorFactory;
    private final ExecutorService executorService;

    public FileProcessorService(FileProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
        // Пул потоков для параллельной обработки
        this.executorService = Executors.newFixedThreadPool(4);
    }

    /**
     * Обрабатывает один файл синхронно.
     * @param filePath путь к файлу
     * @param config конфигурация
     * @return результат обработки
     */
    public ProcessingResult processFile(String filePath, ProcessingConfig config) {
        // Создаём НОВЫЙ экземпляр обработчика для этого файла
        FileProcessor processor = processorFactory.createProcessor(config.getFileFormat());

        // Настраиваем обработчик
        processor.setFilePath(filePath);
        processor.setConfig(config);

        // Запускаем обработку
        return processor.process();
    }

    /**
     * Обрабатывает несколько файлов параллельно.
     * @param files список файлов для обработки
     * @return список результатов
     */
    public List<ProcessingResult> processFilesInParallel(List<FileToProcess> files) {
        List<Future<ProcessingResult>> futures = new ArrayList<>();

        // Отправляем каждый файл в отдельный поток
        for (FileToProcess file : files) {
            Future<ProcessingResult> future = executorService.submit(() ->
                    processFile(file.getFilePath(), file.getConfig())
            );
            futures.add(future);
        }

        // Собираем результаты
        List<ProcessingResult> results = new ArrayList<>();
        for (Future<ProcessingResult> future : futures) {
            try {
                results.add(future.get());
            } catch (Exception e) {
                log.error("Ошибка получения результата", e);
                // Создаём фейковый результат с ошибкой
                ProcessingResult errorResult = new ProcessingResult();
                errorResult.setSuccess(false);
                errorResult.addError("Ошибка выполнения: " + e.getMessage());
                results.add(errorResult);
            }
        }

        return results;
    }

    /**
     * Закрывает пул потоков.
     */
    public void shutdown() {
        executorService.shutdown();
    }
}
