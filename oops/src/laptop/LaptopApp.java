package laptop;

/* Association between classes */

public class LaptopApp {
    public static void main(String[] args) {

        Processor processor1 = new Processor();
        RAM ram1 = new RAM();
        Hdd hdd1 = new Hdd();
        User user1 = new User();

        Processor processor2 = new Processor();
        RAM ram2 = new RAM();
        Hdd hdd2 = new Hdd();
        User user2 = new User();

        //user 1 details
        user1.setName("Manav");
        processor1.setSize(10);
        processor1.setType("Pro");

        ram1.setGen(1);
        ram1.setSize("16GB");

        hdd1.setSize("1TB");
        hdd1.setType(3);

        //user 2 details
        user2.setName("Rashi");
        processor2.setSize(14);
        processor2.setType("Max");

        ram2.setGen(1);
        ram2.setSize("32GB");

        hdd2.setSize("2TB");
        hdd2.setType(3);

        Laptop laptopManav = new Laptop(processor1,ram1,hdd1,user1);

        Laptop laptopRashi = new Laptop(processor2,ram2,hdd2,user2);

        System.out.println("Laptop details");

        System.out.println(laptopManav);

        System.out.println(laptopRashi);


    }
}