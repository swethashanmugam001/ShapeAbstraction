import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketBooker {

    public static void main(String[] args) {

        int numOfThreads = 10;
        int numOfBookings = 5;

        ExecutorService pool = Executors.newFixedThreadPool(numOfThreads);

        for (int i = 1; i <= numOfBookings; i++) {
            pool.execute(new TicketThread(i));
        }

        pool.shutdown();
    }
}
