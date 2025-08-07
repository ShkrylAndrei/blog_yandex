package info.shkryl.priorityQueue.example1;

class Patient {

    String name;
    int priority; // 1 = высокий, 5 = низкий

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + "(приоритет: " + priority + ")";
    }
}
