package laptop;

public class Laptop {

    public static final String LOGO = "MAC";

    private Processor processor;
    private RAM ram;
    private Hdd hdd;
    private User user;

    public Laptop(Processor processor, RAM ram, Hdd hdd, User user) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.user = user;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user + "Logo : " + LOGO + ". " + processor + ", " + ram + ", " + hdd;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Laptop otherObject)) {
            return false;
        }

        return user.equals(otherObject.user)
                && processor.equals(otherObject.processor)
                && ram.equals(otherObject.ram)
                && hdd.equals(otherObject.hdd);
    }
}
