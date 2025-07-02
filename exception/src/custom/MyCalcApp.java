package custom;

import java.util.Scanner;
import java.util.logging.Logger;

public class MyCalcApp {

    private static final Logger LOGGER = Logger.getLogger(MyCalcApp.class.getName());

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        LOGGER.info("Enter integer value to be converted to double : ");

        Scanner scanner = new Scanner(System.in);
        int currentNum = scanner.nextInt();

        double result = calc.calDouble(currentNum);
        LOGGER.info("Double value of " + calc.getCurrentVal() + " is " + result);
    }
}
