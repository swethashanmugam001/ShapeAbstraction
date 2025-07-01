import java.util.logging.Logger;

class TicketThread implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(TicketThread.class.getName());

    int ticketNumber;

    TicketThread(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void run() {
        LOGGER.info("Booking received");
        LOGGER.info("Payment processed");
        LOGGER.info("Ticket confirmed");
    }
}


