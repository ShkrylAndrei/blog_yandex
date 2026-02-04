package info.examples.process_different_type_files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Результат обработки файла.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessingResult {
    private String filePath;
    private boolean success;
    private int recordsProcessed;
    private List<String> errors;
    private long processingTimeMs;

    public void addError(String error) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
    }
}
