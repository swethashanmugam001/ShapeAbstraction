class TicketThread implements Runnable {

    int ticketNumber;

    TicketThread(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void run() {
        System.out.println("Booking received");
        System.out.println("Payment processed");
        System.out.println("Ticket confirmed");
    }
}


