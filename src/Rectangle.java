public class Rectangle extends Shape{

    double length;
    double width;
    boolean isSquare;

    Rectangle()
    {

    }
    Rectangle(double length, double width, boolean isSquare)
    {
        if(isSquare)
        {
            setDimensions(length);
        }
        else
        {
            setDimensions(length,width);
        }
    }

    void setDimensions(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    void setDimensions(double value)
    {
        this.length = value;
        this.width = value;
    }

    double calculateArea(){
        return length*width;
    }

    double calculatePerimeter(){
        return (length+width)*2;
    }

    @Override
    public String toString() {
        return "Rectangle..." + "length= " + length + " width= " + width;
    }
}
