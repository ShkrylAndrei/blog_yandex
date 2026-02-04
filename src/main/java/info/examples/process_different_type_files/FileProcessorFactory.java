package info.examples.process_different_type_files;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

/**
 * Фабрика для создания обработчиков файлов.
 *
 * ВАЖНО: Нельзя просто инжектить прототипный бин в синглтон-сервис,
 * так как инъекция произойдёт один раз при создании синглтона.
 *
 * Решение: использовать ObjectFactory, который при каждом вызове get()
 * запрашивает новый экземпляр у контекста Spring.
 */
@Component
public class FileProcessorFactory {

    // ObjectFactory создаёт новый экземпляр при каждом вызове get()
    private final ObjectFactory<CsvFileProcessor> csvProcessorFactory;
    private final ObjectFactory<JsonFileProcessor> jsonProcessorFactory;

    public FileProcessorFactory(
            ObjectFactory<CsvFileProcessor> csvProcessorFactory,
            ObjectFactory<JsonFileProcessor> jsonProcessorFactory) {
        this.csvProcessorFactory = csvProcessorFactory;
        this.jsonProcessorFactory = jsonProcessorFactory;
    }

    /**
     * Создаёт обработчик для указанного формата.
     * @param format формат файла
     * @return обработчик файла
     */
    public FileProcessor createProcessor(String format) {
        switch (format.toLowerCase()) {
            case "csv":
                return csvProcessorFactory.getObject();
            case "json":
                return jsonProcessorFactory.getObject();
            default:
                throw new IllegalArgumentException("Неизвестный формат: " + format);
        }
    }
}
