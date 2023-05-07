package AlonsoProjectCLI.Booking;

import java.util.Arrays;
import java.util.UUID;

public class BookingDAO {
    private static final Booking[] bookings;

    static {
        bookings = new Booking[10];
    }

    public void addBooking(Booking booking) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                booking.setBookingId(UUID.randomUUID());
                bookings[i] = booking;
                break;
            }

        }
    }

    public Booking[] getBookings(){
        return bookings;
    }
}
