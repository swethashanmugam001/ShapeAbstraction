package abstraction;

public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width, boolean isSquare) {
        if (isSquare) {
            setDimensions(length);
        } else {
            setDimensions(length, width);
        }
    }

    public void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setDimensions(double value) {
        this.length = value;
        this.width = value;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle properties : " + "length= " + length + ", width= " + width;
    }
}
