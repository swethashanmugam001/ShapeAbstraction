package ShapeAbstraction;

public class Circle extends Shape{

    Circle(double radius)
    {
        this.radius = radius;
    }
    double radius;

    double calculateArea(){
        return 3.14*radius*radius;
    }

    double calculatePerimeter(){
        return 2*3.14*radius;
    }

    @Override
    public String toString() {
        return "ShapeAbstraction.Circle..." + "radius= " + radius;
    }
}
