package laptop;

public class Hdd {

    private String size;
    private int type;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HDD [" + " size: " + getSize() + " Type: " + getType() + " ]";
    }
}
