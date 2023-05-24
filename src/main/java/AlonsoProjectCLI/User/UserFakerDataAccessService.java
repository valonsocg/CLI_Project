package AlonsoProjectCLI.User;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDao {
    private final Faker faker;

    public UserFakerDataAccessService() {
        this.faker = new Faker();
    }

    @Override
    public List<User> getUsers() {

        int count = 0;
        List<User> users = new ArrayList<>();
        while (count <= 20){
            String name = faker.name().firstName();
            String lastname = faker.name().lastName();
            UUID idNumber = UUID.randomUUID();
            users.add(new User(name, lastname, idNumber));
            count++;
        }
        return users;
    }
}
