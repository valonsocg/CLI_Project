package AlonsoProjectCLI;

import AlonsoProjectCLI.Car.Car;
import AlonsoProjectCLI.Car.CarDAO;
import AlonsoProjectCLI.Car.CarService;
import AlonsoProjectCLI.User.User;
import AlonsoProjectCLI.User.UserDAO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import AlonsoProjectCLI.User.UserService;
import AlonsoProjectCLI.Booking.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDao = new UserDAO();
        CarDAO carDAO = new CarDAO();
        BookingDAO bookingDAO = new BookingDAO();

        UserService userService = new UserService();
        CarService carService = new CarService();
        BookingService bookingService = new BookingService();


        while (true) {
            System.out.println("1️⃣ - Book Car");
            System.out.println("2️⃣ - View All User Booked Cars");
            System.out.println("3️⃣ - View All Bookings");
            System.out.println("4️⃣ - View Available Cars");
            System.out.println("5️⃣ - View Available Electric Cars");
            System.out.println("6️⃣ - View All Users");
            System.out.println("7️⃣ - Exit");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    try {
                    System.out.println("Book car");
                    System.out.println("Enter user ID:");
                    String userIdStr = scanner.nextLine();
                    UUID userId = UUID.fromString(userIdStr);
                    System.out.println("Enter car registration number:");
                    String regNumber = scanner.nextLine();
                    System.out.println("Enter booking date (YYYY-MM-DD):");
                    String bookingDateStr = scanner.nextLine();
                    LocalDate bookingDate = LocalDate.parse(bookingDateStr);

                        bookingService.bookCar(userId, regNumber, bookingDate);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        System.out.println("View all user booked cars");
                        System.out.println("Enter user ID:");
                        String userIdStr2 = scanner.nextLine();
                        UUID userId2 = UUID.fromString(userIdStr2);
                        bookingService.viewUserBookings(userId2);
                    }catch (IllegalArgumentException e){
                        System.out.println("Invalid id");
                    }
                    break;
                case "3":
                    System.out.println("View All Bookings");
                    Booking[] allBookings = bookingService.viewAllBookings();
                    for (Booking booking : allBookings) {
                        System.out.println("Booking ID: " + booking.getBookingId());
                        System.out.println("User: " + booking.getUser().getFirstName() + " " + booking.getUser().getLastName());
                        System.out.println("Car: " + booking.getCar().getRegNumber());
                        System.out.println("Booking Date: " + booking.getDateTime());
                        System.out.println("Canceled: " + (booking.isCanceled() ? "Yes" : "No"));
                        System.out.println("-------------------------");
                    }
                    break;
                case "4":
                    System.out.println("View Available Cars");
                    Car[] availableCars = carService.getAvailableCars();
                    for (Car cars : availableCars) {
                        System.out.println(cars);
                    }
                    break;
                case "5":
                    System.out.println("View Available Electric Cars");

                    Car[] availableElectricalCarsCars = carService.getAvailableElectricalCars();
                    for (Car cars : availableElectricalCarsCars) {
                        System.out.println(cars);
                    }
                    break;
                case "6":
                    System.out.println("View all users");
                    User[] allUsers = userService.viewAllUsers();
                    for (User users : allUsers) {
                        System.out.println(users);
                    }
                    break;
                case "7":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println(input + " not a valid option ❌");

            }
        }
    }
}