package com.oops.abstraction;

import java.util.*;

/* Abstract class Shape and methods implemented by Circle, Triangle and Rectangle to calculate Area and Perimeter */

public class ShapeCalculator {
    public static void main(String[] args) {

        boolean isSquare = true;

        Shape circle = new Circle(3);
        Shape triangle = new Triangle(3, 4, 5);
        Shape rectangle = new Rectangle(10, 5, isSquare);

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(circle);
        shapeList.add(rectangle);
        shapeList.add(triangle);

        for (Shape shape : shapeList) {
            System.out.println(shape.toString());

            System.out.println("Area..");
            System.out.println(shape.calculateArea());

            System.out.println("Perimeter..");
            System.out.println(shape.calculatePerimeter());
            System.out.println("\n");

        }
    }
}
