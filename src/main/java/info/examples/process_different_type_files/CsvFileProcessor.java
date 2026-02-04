package info.examples.process_different_type_files;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Обработчик CSV файлов.
 *
 * @Scope("prototype") - каждый запрос на этот бин создаёт новый экземпляр.
 * Это критически важно, так как каждый файл имеет своё состояние.
 */
@Slf4j
@Component
@Scope("prototype")  // <-- КЛЮЧЕВОЙ АННОТАЦИЯ
public class CsvFileProcessor extends AbstractFileProcessor {

    @Override
    public ProcessingResult process() {
        long startTime = System.currentTimeMillis();
        ProcessingResult result = new ProcessingResult();
        result.setFilePath(filePath);

        try {
            startProcessing();

            // Имитация обработки с прогрессом
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                // Имитация обработки записи
                processCsvLine(line, lineCount);

                // Обновление прогресса каждые 10 строк
                if (lineCount % 10 == 0) {
                    updateProgress(Math.min(95, lineCount / 10));
                    Thread.sleep(50); // имитация работы
                }
            }

            reader.close();

            // Финальные шаги
            if (config.isValidate()) {
                validateCsvFile();
                updateProgress(98);
            }

            finishProcessing();
            updateProgress(100);

            result.setSuccess(true);
            result.setRecordsProcessed(lineCount);
            result.setProcessingTimeMs(System.currentTimeMillis() - startTime);

            log.info("CSV файл обработан успешно: {} записей", lineCount);

        } catch (Exception e) {
            log.error("Ошибка обработки CSV файла: {}", filePath, e);
            result.setSuccess(false);
            result.addError("Ошибка обработки: " + e.getMessage());
            result.setProcessingTimeMs(System.currentTimeMillis() - startTime);
        }

        return result;
    }

    /**
     * Обработка одной строки CSV.
     * В реальном приложении здесь была бы логика парсинга и валидации.
     */
    private void processCsvLine(String line, int lineNumber) {
        // Просто логируем для примера
        if (lineNumber <= 5) { // первые 5 строк для демонстрации
            log.debug("Строка {}: {}", lineNumber, line);
        }
    }

    /**
     * Валидация CSV файла.
     */
    private void validateCsvFile() throws Exception {
        log.info("Запуск валидации CSV файла...");
        // Имитация валидации
        Thread.sleep(200);
        log.info("Валидация завершена");
    }
}