package info.examples.process_different_type_files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для передачи информации о файле для обработки.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileToProcess {
    private String filePath;
    private ProcessingConfig config;
}
