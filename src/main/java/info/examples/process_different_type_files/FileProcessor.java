package info.examples.process_different_type_files;

/**
        * Интерфейс для обработки файлов.
        * Каждый файл должен иметь свой независимый обработчик,
        * так как обработчик хранит состояние обработки.
        */
public interface FileProcessor {

    /**
     * Устанавливает путь к файлу для обработки.
     * @param filePath путь к файлу
     */
    void setFilePath(String filePath);

    /**
     * Устанавливает параметры обработки.
     * @param config конфигурация обработки
     */
    void setConfig(ProcessingConfig config);

    /**
     * Запускает обработку файла.
     * @return результат обработки
     */
    ProcessingResult process();

    /**
     * Возвращает текущий прогресс обработки (0-100).
     * @return процент выполнения
     */
    int getProgress();
}
