package info.shkryl.immutableCollection.checkData;

import java.util.List;

public class StudentService {

    private final List<String> validSubjects;

    // Конструктор принимает список, но сохраняет его копию
    public StudentService(List<String> subjects) {
        this.validSubjects = List.copyOf(subjects); // Java 10+
    }

    public boolean isValidSubject(String subject) {
        return validSubjects.contains(subject);
    }
}
