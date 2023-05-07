package AlonsoProjectCLI.Car;

import java.util.Arrays;

public class CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car("1234", 85, Brand.TOYOTA, Motor.GASOLINE),
                new Car("456", 75, Brand.TESLA, Motor.ELECTRICAL),
                new Car("789", 65, Brand.BMW, Motor.HYBRID),
                new Car("9876", 95, Brand.MERCEDES, Motor.ELECTRICAL)
        };
    }

    public Car[] viewAllCars() {
        return cars;
    }


}
