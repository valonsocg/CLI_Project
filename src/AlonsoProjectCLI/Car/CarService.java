package AlonsoProjectCLI.Car;

import AlonsoProjectCLI.Booking.Booking;
import AlonsoProjectCLI.Booking.BookingDAO;

import java.util.Arrays;

public class CarService {
    private final CarDAO carDAO;
    private final BookingDAO bookingDAO;

    public CarService(CarDAO carDAO, BookingDAO bookingDAO) {
        this.carDAO = carDAO;
        this.bookingDAO = bookingDAO;
    }

    public Car[] getAllCars() {
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

    public Car[] getAvailableElectricalCars() {
        Car[] allCars = getAvailableCars();
        Car[] electricalCars = new Car[allCars.length];
        int index = 0;
        for (Car cars : allCars) {
            if (cars.getMotor().equals(Motor.ELECTRICAL)) {
                electricalCars[index++] = cars;
            }
        }
        return Arrays.copyOf(electricalCars, index);
    }

    public Car[] getAvailableCars() {
        Car[] allCars = getAllCars();
        Booking[] bookings = bookingDAO.getBookings();

        Car[] availableCars = new Car[allCars.length];

        int availableCarsCount = 0;

        for (Car car : allCars) {
            boolean isBooked = false;
            for (Booking booking : bookings) {
                if (booking != null && booking.getCar().equals(car)) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                availableCars[availableCarsCount++] = car;

            }
        }
        return Arrays.copyOf(availableCars, availableCarsCount);
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
