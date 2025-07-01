package exception;

import java.util.Scanner;

/**
 MyCalcApp to throw MyArithException - custom exception thrown and app terminates when entered value is 0 or -1
 **/

public class MyCalcApp {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Enter integer value to be converted to double : ");

        Scanner scanner = new Scanner(System.in);
        int currentNum = scanner.nextInt();

        double result = calc.calDouble(currentNum);
        System.out.println("Double value of " + calc.getCurrentVal() + " is " + result);
    }
}
