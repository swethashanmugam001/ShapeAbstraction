package LaptopOOPExample;

public class Processor {

    private int size;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "Processor ["  + "type : " + getType() + " size : " + getSize() + "] ";
    }
}
