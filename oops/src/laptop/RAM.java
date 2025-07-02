package laptop;

public class RAM {

    private int size;
    private String generation;

    public RAM(int size, String generation) {
        this.size = size;
        this.generation = generation;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "RAM [" + " size: " + size + "GB, " + "generation: " + generation + "] ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RAM otherObject)) {
            return false;
        }

        return size == otherObject.size && generation.equals(otherObject.generation);
    }
}
