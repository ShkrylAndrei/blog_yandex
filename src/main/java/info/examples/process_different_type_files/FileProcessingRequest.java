package info.examples.process_different_type_files;

import lombok.Data;

/**
 * DTO для запроса обработки одного файла.
 */
@Data
public class FileProcessingRequest {
    private String filePath;
    private String format;      // "csv", "json"
    private String encoding;    // "UTF-8"
    private String delimiter;   // ",", ";"
    private boolean validate;
    private int batchSize;
}
