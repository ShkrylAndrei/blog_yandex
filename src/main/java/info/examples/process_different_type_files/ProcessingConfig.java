package info.examples.process_different_type_files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Конфигурация обработки файла.
 * Содержит параметры, специфичные для каждого файла.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessingConfig {
    private String fileFormat;      // "csv", "json", "xml"
    private String encoding;        // "UTF-8", "CP1251"
    private String delimiter;       // для CSV: ",", ";", "\t"
    private boolean validate;       // выполнять ли валидацию
    private int batchSize;          // размер пакета для обработки
}
