package info.shkryl.useAbstractClass.exampleTwo;

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius; // Площадь круга
    }

    @Override
    void displayType() {
        System.out.println("This is a Circle.");
    }
}
