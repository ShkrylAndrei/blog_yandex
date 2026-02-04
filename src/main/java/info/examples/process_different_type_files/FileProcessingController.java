package info.examples.process_different_type_files;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST контроллер для тестирования обработки файлов.
 */
@RestController
@RequestMapping("/api/files")
public class FileProcessingController {

    private final FileProcessorService processingService;

    public FileProcessingController(FileProcessorService processingService) {
        this.processingService = processingService;
    }

    /**
     * Обработка одного файла.
     */
    @PostMapping("/process")
    public ProcessingResult processFile(@RequestBody FileProcessingRequest request) {
        ProcessingConfig config = new ProcessingConfig(
                request.getFormat(),
                request.getEncoding(),
                request.getDelimiter(),
                request.isValidate(),
                request.getBatchSize()
        );

        return processingService.processFile(request.getFilePath(), config);
    }

    /**
     * Параллельная обработка нескольких файлов.
     */
    @PostMapping("/process-batch")
    public List<ProcessingResult> processBatch(@RequestBody BatchProcessingRequest request) {
        List<FileToProcess> files = request.getFiles().stream()
                .map(file -> {
                    ProcessingConfig config = new ProcessingConfig(
                            file.getFormat(),
                            file.getEncoding(),
                            file.getDelimiter(),
                            file.isValidate(),
                            file.getBatchSize()
                    );
                    return new FileToProcess(file.getFilePath(), config);
                })
                .collect(Collectors.toList());

        return processingService.processFilesInParallel(files);
    }
}
