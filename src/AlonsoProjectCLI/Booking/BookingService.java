package AlonsoProjectCLI.Booking;

import AlonsoProjectCLI.Car.Car;
import AlonsoProjectCLI.Car.CarService;
import AlonsoProjectCLI.User.User;
import AlonsoProjectCLI.User.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final UserService userService;
    private final CarService carService;
    private final BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO, CarService carService, UserService userService) {
        this.userService = userService;
        this.carService = carService;
        this.bookingDAO = bookingDAO;
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

    public List<Booking> viewAllBookings() {
        return bookingDAO.getBookings();
    }

    public void viewUserBookings(UUID userId){
        User user = userService.getUserById(userId);
        if(user == null){
            System.out.println("User not found.");
            return;
        }

        List<Booking> bookings = bookingDAO.getBookings();
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
