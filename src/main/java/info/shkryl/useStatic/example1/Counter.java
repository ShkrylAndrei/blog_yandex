package info.shkryl.useStatic.example1;

public class Counter {
    private String name;
    private static int count = 0; // Статическое поле

    public Counter(String name) {
        this.name = name;
        count++; // Увеличиваем при каждом создании
    }

    // Статический метод для доступа к статическому полю
    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Counter counter1=new Counter("1");
        Counter counter2 = new Counter("2");
        int count = Counter.getCount();
        System.out.println("Создано объектов Counter = "+count);
    }
}
