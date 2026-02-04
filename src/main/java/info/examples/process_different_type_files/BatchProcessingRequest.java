package info.examples.process_different_type_files;

import lombok.Data;

import java.util.List;

/**
 * DTO для пакетной обработки файлов.
 */
@Data
public class BatchProcessingRequest {
    private List<FileProcessingRequest> files;
}
