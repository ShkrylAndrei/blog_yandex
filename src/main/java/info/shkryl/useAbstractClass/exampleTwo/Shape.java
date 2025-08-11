package info.shkryl.useAbstractClass.exampleTwo;

abstract class Shape {
    // Абстрактный метод для расчета площади
    abstract double area();

    // Обычный метод для отображения типа фигуры
    void displayType() {
        System.out.println("This is a shape.");
    }
}
