package AlonsoProjectCLI.Car;

import AlonsoProjectCLI.Booking.Booking;
import AlonsoProjectCLI.Booking.BookingDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Car> electricalCars = allCars.stream()
                .filter(c -> c.getMotor().equals(Motor.ELECTRICAL))
                .collect(Collectors.toList());
        return electricalCars;
    }

    public List<Car> getAvailableCars() {
        List<Car> allCars = getAllCars();
        List<Booking> bookings = bookingDAO.getBookings();

        List<Car> availableCars = allCars.stream()
                .filter(car -> bookings.stream().noneMatch(booking -> booking != null && booking.getCar().equals(car)))
                .collect(Collectors.toList());
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
