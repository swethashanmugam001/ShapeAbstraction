package custom;

public class Calculator {

    private int currentVal;

    public int getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(int currentVal) {
        this.currentVal = currentVal;
    }

    double calDouble(int currentVal) throws MyArithException {

        setCurrentVal(currentVal);

        if (currentVal < 0)
            throw new MyArithException("Negative not allowed");
        else if (currentVal == 0)
            throw new MyArithException("Zero not allowed");

        return (double) currentVal;
    }
}
