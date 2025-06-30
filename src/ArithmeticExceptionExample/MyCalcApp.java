package ArithmeticExceptionExample;

public class MyCalcApp {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

         calc.calDouble(0);
         calc.calDouble(-1);

        double result = calc.calDouble(5);
        System.out.println("Double value of " + calc.getCurrentVal() + " is " + result);
    }
}
