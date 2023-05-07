package AlonsoProjectCLI.User;

import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static {
        users = new User[]{
                new User("James", "Sanchez", UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3")),
                new User("Jamila", "Juarez", UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3")),
                new User("John", "Doe", UUID.fromString("ddc0b236-287e-4729-b066-f838859df190")),
                new User("Alonso", "Carter", UUID.fromString("7a71fa21-8d7a-44d8-bede-b52c68f30f6e")),

        };
    }

        public User[] getUsers () {
            return users;
        }


    }

