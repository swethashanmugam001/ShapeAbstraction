package laptop;

public class Hdd {

    private String type;
    private int size;

    public Hdd(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HDD [" + " size: " + size + " Type: " + type + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hdd otherObject)) {
            return false;
        }
        return size == otherObject.size && type.equals(otherObject.type);
    }
}
