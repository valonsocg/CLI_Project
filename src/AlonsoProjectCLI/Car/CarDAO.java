package AlonsoProjectCLI.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDAO {
    private final List<Car> cars;

    public CarDAO() {
        cars = new ArrayList<>();
        cars.add(new Car("1234", 85, Brand.TOYOTA, Motor.GASOLINE));
        cars.add(new Car("456", 75, Brand.TESLA, Motor.ELECTRICAL));
        cars.add(new Car("789", 65, Brand.BMW, Motor.HYBRID));
        cars.add(new Car("9876", 95, Brand.MERCEDES, Motor.ELECTRICAL));
    }


    public List<Car> viewAllCars() {
        return cars;
    }


}
