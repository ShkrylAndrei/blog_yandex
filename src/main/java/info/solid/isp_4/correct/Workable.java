package info.solid.isp_4.correct;

public interface Workable {
    void work();
}
interface Eatable {
    void eat();
}
interface Sleepable {
    void sleep();
}

class HumanWorker implements Workable, Eatable, Sleepable {
    @Override
    public void eat() {
    }

    @Override
    public void sleep() {
    }

    @Override
    public void work() {
    }
    // реализует все
}
class RobotWorker implements Workable {
    @Override
    public void work() {
    }
    // только work()
}
