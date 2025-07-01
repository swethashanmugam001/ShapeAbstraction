package abstraction;

public class Triangle extends Shape {

    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double calculateArea() {
        double semiPerimeter = (calculatePerimeter()) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    public double calculatePerimeter() {
        return side1 + side2 + side2;
    }

    @Override
    public String toString() {
        return "Triangle..." + "side1= " + side1 + " side2= " + side2 + " side3= " + side3;
    }
}
