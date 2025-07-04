package LinkedList.CircularLinkedList;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservation {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null)
            return;
        Ticket current = head, prev = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head)
                        head = current.next;
                    if (current == tail)
                        tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId +
                    ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName +
                    ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String keyword) {
        if (head == null)
            return;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketId +
                        ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName +
                        ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
            }
            current = current.next;
        } while (current != head);
    }

    public int countTickets() {
        if (head == null)
            return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Inception", "A2", "10:00 AM");

        System.out.println("All Tickets:");
        system.displayTickets();

        System.out.println("\nSearching for 'Inception':");
        system.searchTicket("Inception");

        System.out.println("\nRemoving Ticket ID 2:");
        system.removeTicket(2);

        System.out.println("\nUpdated Tickets:");
        system.displayTickets();

        System.out.println("\nTotal Booked Tickets: " + system.countTickets());
    }
}
