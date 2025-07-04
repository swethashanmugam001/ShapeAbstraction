package abstraction;

import static java.lang.Math.PI;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle property : " + "radius= " + radius;
    }
}
