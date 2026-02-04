package info.examples.process_different_type_files;

import lombok.extern.slf4j.Slf4j;

/**
 * Абстрактный обработчик файла с состоянием.
 *
 * ВАЖНО: Этот класс хранит состояние (путь, конфиг, прогресс),
 * поэтому его нельзя использовать как синглтон!
 * Каждый файл должен иметь свой экземпляр.
 */
@Slf4j
public abstract class AbstractFileProcessor implements FileProcessor {

    // Состояние, уникальное для каждого файла
    protected String filePath;
    protected ProcessingConfig config;
    protected int progress;          // 0-100
    protected boolean processing;    // флаг обработки

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        log.info("Установлен путь к файлу: {}", filePath);
    }

    @Override
    public void setConfig(ProcessingConfig config) {
        this.config = config;
        log.info("Установлена конфигурация: {}", config);
    }

    @Override
    public int getProgress() {
        return progress;
    }

    protected void updateProgress(int percentage) {
        this.progress = percentage;
        log.debug("Прогресс обработки {}: {}%", filePath, progress);
    }

    protected void startProcessing() {
        this.processing = true;
        this.progress = 0;
        log.info("Начата обработка файла: {}", filePath);
    }

    protected void finishProcessing() {
        this.processing = false;
        this.progress = 100;
        log.info("Завершена обработка файла: {}", filePath);
    }
}
