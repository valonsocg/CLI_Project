package AlonsoProjectCLI.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {


    private final List<User> users;

    public UserArrayDataAccessService() {
        users = new ArrayList<>();
        users.add(new User("James", "Sanchez", UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3")));
        users.add(new User("Jamila", "Juarez", UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3")));
        users.add(new User("John", "Doe", UUID.fromString("ddc0b236-287e-4729-b066-f838859df190")));
        users.add(new User("Alonso", "Carter", UUID.fromString("7a71fa21-8d7a-44d8-bede-b52c68f30f6e")));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }


}

