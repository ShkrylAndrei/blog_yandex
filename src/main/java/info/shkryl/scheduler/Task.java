package info.shkryl.scheduler;

import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime time;

    public Task(String description, LocalTime time) {
        this.description = description;
        this.time = time;
    }

    // Геттеры
    public String getDescription() {
        return description;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time + " — " + description;
    }
}
