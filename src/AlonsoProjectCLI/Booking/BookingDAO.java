package AlonsoProjectCLI.Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookingDAO {

    private final List<Booking> bookings;

    public BookingDAO(){
        bookings = new ArrayList<>();
    }

//    static {
//        bookings = new ArrayList<Booking>();
//    }

    public void addBooking(Booking booking) {
        booking.setBookingId(UUID.randomUUID());
        bookings.add(booking);
    }

    public List<Booking> getBookings(){
        return bookings;
    }
}
