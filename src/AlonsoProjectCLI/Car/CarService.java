package AlonsoProjectCLI.Car;

import AlonsoProjectCLI.Booking.Booking;
import AlonsoProjectCLI.Booking.BookingDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final CarDAO carDAO;
    private final BookingDAO bookingDAO;

    public CarService(CarDAO carDAO, BookingDAO bookingDAO) {
        this.carDAO = carDAO;
        this.bookingDAO = bookingDAO;
    }

    public List<Car> getAllCars() {
        return carDAO.viewAllCars();
    }

    public Car getCar(String regNumber) {
        for (Car car : getAllCars()) {
            if (regNumber.equals(car.getRegNumber())) {
                return car;
            }
        }
        throw new IllegalStateException(String.format("Car with reg %s not found", regNumber));
    }

    public List<Car> getAvailableElectricalCars() {
        List<Car> allCars = getAvailableCars();
        List<Car> electricalCars = new ArrayList<>();
        for (Car cars : allCars) {
            if (cars.getMotor().equals(Motor.ELECTRICAL)) {
                electricalCars.add(cars);
            }
        }
        return electricalCars;
    }

    public List<Car> getAvailableCars() {
        List<Car> allCars = getAllCars();
        List<Booking> bookings = bookingDAO.getBookings();

        List<Car> availableCars = new ArrayList<>();

        for (Car car : allCars) {
            boolean isBooked = false;
            for (Booking booking : bookings) {
                if (booking != null && booking.getCar().equals(car)) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                availableCars.add(car);

            }
        }
        return availableCars;
    }

    public Car getCarByRegNumber(String regNumber) {
        for (Car car : getAllCars()) {
            if (car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        return null;
    }
}
