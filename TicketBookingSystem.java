/*  
 *Hard Level:
Develop a ticket booking system with synchronized threads to ensure no double booking of seats. Use thread priorities to simulate VIP bookings being processed first.
 */
import java.util.*;


class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public synchronized boolean isBooked() {
        return isBooked;
    }

    public synchronized boolean book() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }
}

class BookingThread extends Thread {
    private String customerType;
    private String customerName;
    private TicketBookingSystem bookingSystem;

    public BookingThread(String customerType, String customerName, TicketBookingSystem bookingSystem) {
        this.customerType = customerType;
        this.customerName = customerName;
        this.bookingSystem = bookingSystem;
     
        setPriority(customerType.equals("VIP") ? MAX_PRIORITY : NORM_PRIORITY);
    }

    @Override
    public void run() {
        Seat bookedSeat = bookingSystem.bookSeat(customerType, customerName);
        if (bookedSeat != null) {
            System.out.println(customerType + " Customer " + customerName + 
                             " successfully booked seat " + bookedSeat.getSeatNumber());
        } else {
            System.out.println(customerType + " Customer " + customerName + 
                             " could not book a seat - House Full!");
        }
    }
}

public class TicketBookingSystem {
    private List<Seat> seats;
    private static final int TOTAL_SEATS = 10;

    public TicketBookingSystem() {
        seats = new ArrayList<>();
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            seats.add(new Seat(i));
        }
    }

    public synchronized Seat bookSeat(String customerType, String customerName) {
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                try {
             
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (seat.book()) {
                    return seat;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        List<Thread> threads = new ArrayList<>();

    
        for (int i = 1; i <= 5; i++) {
            threads.add(new BookingThread("VIP", "VIP-" + i, bookingSystem));
        }

      
        for (int i = 1; i <= 8; i++) {
            threads.add(new BookingThread("Regular", "Regular-" + i, bookingSystem));
        }

 
        for (Thread thread : threads) {
            thread.start();
        }

      
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nBooking process completed!");
    }
}