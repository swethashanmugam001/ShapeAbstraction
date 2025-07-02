package laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LaptopApp {

    private static final Logger LOGGER = Logger.getLogger(LaptopApp.class.getName());

    public static void main(String[] args) {

        Processor processor1 = new Processor(2, "i3");
        RAM ram1 = new RAM(16, "DDR1");
        Hdd hdd1 = new Hdd(1024, "SSD");
        User user1 = new User("Manav");

        Processor processor2 = new Processor(3, "i5");
        RAM ram2 = new RAM(32, "DDR2");
        Hdd hdd2 = new Hdd(512, "HDD");
        User user2 = new User("Rashi");

        Laptop laptopManav = new Laptop(processor1,ram1,hdd1,user1);
        Laptop laptopRashi = new Laptop(processor2,ram2,hdd2,user2);

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptopManav);
        laptops.add(laptopRashi);

        LOGGER.info("Laptop details : \n");

        for (Laptop laptop : laptops) {
            LOGGER.info(laptop.toString() + "\n");
        }

        LOGGER.info("Are the two laptops the same? " + laptopManav.equals(laptopRashi));
    }
}