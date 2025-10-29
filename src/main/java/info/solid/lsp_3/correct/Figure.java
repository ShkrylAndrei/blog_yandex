package info.solid.lsp_3.correct;

public class Figure {
}

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private final double width, height;

    @Override
    public double getArea() {
        return 0;
    }

    public Rectangle(int width,int height){
        this.width=width;
        this.height=height;
    }
}

class Square implements Shape {
    private final double side;

    @Override
    public double getArea() {
        return 0;
    }

    public Square(int side){
        this.side=side;
    }
}
