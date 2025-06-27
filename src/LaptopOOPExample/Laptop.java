package LaptopOOPExample;

public class Laptop {

    public static final String logo = "MAC";

    Processor processor;
    RAM ram;
    HDD hdd;
    User user;

    Laptop(Processor processor, RAM ram, HDD hdd, User user)
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
