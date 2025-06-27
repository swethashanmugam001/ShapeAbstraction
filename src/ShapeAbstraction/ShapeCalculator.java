package ShapeAbstraction;

import java.util.*;


public class ShapeCalculator {
    public static void main(String[] args) {

        boolean isSquare = false;

        Shape circle = new Circle(3);
        Shape triangle = new Triangle(3,4,5);
        Shape rectangle = new Rectangle(10,5,isSquare);

        /*
        Old code - if we are using default ShapeAbstraction.Rectangle constructor without sending length and width
        ShapeAbstraction.Shape rectangle = new ShapeAbstraction.Rectangle();
        double rectangleSingleValue = 10;
        //if isSquare is false then these fields will be considered for rectangle
        double rectangleLength = 10;
        double rectangleWidth = 5;*/

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(circle);
        shapeList.add(rectangle);
        shapeList.add(triangle);

        for(Shape shape: shapeList)
        {
            System.out.println(shape.toString());

            /*
            Old code - if we are using default ShapeAbstraction.Rectangle constructor without sending length and width
            if(shape instanceof ShapeAbstraction.Rectangle)
            {
                //Compile time polymorphism example for ShapeAbstraction.Rectangle
                if(isSquare) {
                    System.out.println("length = " +rectangleSingleValue+ " width = "+rectangleSingleValue);
                    shape.setDimensions(rectangleSingleValue);
                }
                else {
                    System.out.println("length = " +rectangleLength+ " width = "+rectangleWidth);
                    shape.setDimensions(rectangleLength, rectangleWidth);
                }
            }*/

            System.out.println("Area..");
            System.out.println(shape.calculateArea());

            System.out.println("Perimeter..");
            System.out.println(shape.calculatePerimeter());
            System.out.println("\n");



        }
    }
}
