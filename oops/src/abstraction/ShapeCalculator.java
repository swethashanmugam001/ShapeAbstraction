package abstraction;

import java.util.*;
import java.util.logging.Logger;

public class ShapeCalculator {

    private static final Logger LOGGER = Logger.getLogger(ShapeCalculator.class.getName());

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
            LOGGER.info(shape.toString());
            LOGGER.info("Area : " + shape.calculateArea());
            LOGGER.info("Perimeter : " + shape.calculatePerimeter() + "\n");
        }
    }
}
