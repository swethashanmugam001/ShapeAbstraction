package laptop;

public class Processor {

    private int gigaHertz;
    private String generation;

    public Processor(int gigaHertz, String generation) {
        this.gigaHertz = gigaHertz;
        this.generation = generation;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public int getGigaHertz() {
        return gigaHertz;
    }

    public void setGigaHertz(int gigaHertz) {
        this.gigaHertz = gigaHertz;
    }

    @Override
    public String toString() {
        return "Processor [" + "generation : " + generation + " GHz : " + gigaHertz + "] ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Processor otherObject)) {
            return false;
        }
        return gigaHertz == otherObject.gigaHertz
                && generation.equals(otherObject.generation);
    }
}
