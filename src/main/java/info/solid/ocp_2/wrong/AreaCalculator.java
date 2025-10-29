package info.solid.ocp_2.wrong;

import info.solid.ocp_2.dto.Circle;
import info.solid.ocp_2.dto.Rectangle;

public class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.getWidth() * r.getHeight();
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.getRadius() * c.getRadius();
        }
        throw new IllegalArgumentException("Неизвестная фигура");
    }
}
