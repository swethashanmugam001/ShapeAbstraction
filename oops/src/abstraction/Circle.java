package abstraction;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle property : " + "radius= " + radius;
    }
}
