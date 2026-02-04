package info.examples.process_different_type_files;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Обработчик JSON файлов.
 *
 * Также прототип, так как каждый JSON файл имеет своё состояние.
 */
@Slf4j
@Component
@Scope("prototype")
public class JsonFileProcessor extends AbstractFileProcessor {

    @Override
    public ProcessingResult process() {
        long startTime = System.currentTimeMillis();
        ProcessingResult result = new ProcessingResult();
        result.setFilePath(filePath);

        try {
            startProcessing();

            // Имитация парсинга JSON
            log.info("Парсинг JSON файла: {}", filePath);
            Thread.sleep(300);
            updateProgress(30);

            // Имитация обработки объектов
            log.info("Обработка JSON объектов...");
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(100);
                updateProgress(30 + i * 10);
            }

            // Валидация если требуется
            if (config.isValidate()) {
                log.info("Валидация JSON структуры...");
                Thread.sleep(250);
                updateProgress(95);
            }

            finishProcessing();
            updateProgress(100);

            result.setSuccess(true);
            result.setRecordsProcessed(150); // примерное количество объектов
            result.setProcessingTimeMs(System.currentTimeMillis() - startTime);

            log.info("JSON файл обработан успешно");

        } catch (Exception e) {
            log.error("Ошибка обработки JSON файла: {}", filePath, e);
            result.setSuccess(false);
            result.addError("Ошибка обработки JSON: " + e.getMessage());
            result.setProcessingTimeMs(System.currentTimeMillis() - startTime);
        }

        return result;
    }
}
