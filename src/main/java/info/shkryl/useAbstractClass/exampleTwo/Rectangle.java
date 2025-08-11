package info.shkryl.useAbstractClass.exampleTwo;

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width; // Площадь прямоугольника
    }

    @Override
    void displayType() {
        System.out.println("This is a Rectangle.");
    }
}
