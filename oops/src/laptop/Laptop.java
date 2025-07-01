package laptop;

public class Laptop {

    public static final String logo = "MAC";

    private final Processor processor;
    private final RAM ram;
    private final Hdd hdd;
    private final User user;

    public Laptop(Processor processor, RAM ram, Hdd hdd, User user)
    {
        this.processor = processor;
        this.ram =  ram;
        this.hdd = hdd;
        this.user = user;
    }

    @Override
    public String toString()
    {
        return user + "Logo : " + logo + ". " + processor + ", " +ram+ ", " + hdd;
    }

}
