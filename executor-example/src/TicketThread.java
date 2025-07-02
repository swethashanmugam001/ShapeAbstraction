import java.util.logging.Logger;

class TicketThread implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(TicketThread.class.getName());

    int ticketNumber;

    TicketThread(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void run() {
        LOGGER.info("Booking received " + ticketNumber);
        makeThreadSleep(300);

        LOGGER.info("Payment processed " + ticketNumber);
        makeThreadSleep(300);

        LOGGER.info("Ticket confirmed " + ticketNumber);
        makeThreadSleep(300);
    }

    private void makeThreadSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {

        }
    }
}


