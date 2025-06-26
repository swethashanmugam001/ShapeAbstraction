public class Triangle extends Shape {

    double side1;
    double side2;
    double side3;

    Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double calculateArea(){
        double semiPerimeter = (calculatePerimeter())/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    double calculatePerimeter(){
        return side1+side2+side2;
    }
    @Override
    public String toString() {
        return "Triangle..." + "side1= " + side1 + " side2= " + side2 + " side3= " +side3;
    }
}
