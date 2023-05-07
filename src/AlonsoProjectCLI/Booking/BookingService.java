package AlonsoProjectCLI.Booking;

import AlonsoProjectCLI.Car.Car;
import AlonsoProjectCLI.Car.CarService;
import AlonsoProjectCLI.User.User;
import AlonsoProjectCLI.User.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class BookingService {
    private UserService userService;
    private CarService carService;
    private BookingDAO bookingDAO;

    public BookingService() {
        this.userService = new UserService();
        this.carService = new CarService();
        this.bookingDAO = new BookingDAO();
    }

    public void bookCar(UUID userId, String regNumber, LocalDate bookingDate){
        User user = userService.getUserById(userId);
        if(user == null){
            System.out.println("User not found. Booking failed.");
            return;
        }

        Car car = carService.getCarByRegNumber(regNumber);
        if (car == null) {
            System.out.println("Car not found. Booking failed.");
            return;
        }

        Booking booking = new Booking(UUID.randomUUID(), user, car, bookingDate);
        bookingDAO.addBooking(booking);
        System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
    }

    public Booking[] viewAllBookings() {
        Booking[] bookings = bookingDAO.getBookings();
        Booking[] validBookings = new Booking[bookings.length];
        int index = 0;

        for (Booking booking : bookings) {
            if (booking != null) {
                validBookings[index] = booking;
                index++;
            }
        }

        return Arrays.copyOf(validBookings, index);
    }

    public void viewUserBookings(UUID userId){
        User user = userService.getUserById(userId);
        if(user == null){
            System.out.println("User not found.");
            return;
        }

        Booking[] bookings = bookingDAO.getBookings();
        System.out.println("User Booked Cars:");
        for (Booking booking: bookings) {
            if(booking!=null && booking.getUser().getId().equals(userId)){
                System.out.println("Car: " + booking.getCar().getRegNumber());
                System.out.println("Booking Date: " + booking.getDateTime());
                System.out.println("Canceled: " + (booking.isCanceled() ? "Yes" : "No"));
                System.out.println("-------------------------");
            }
        }

    }
}
