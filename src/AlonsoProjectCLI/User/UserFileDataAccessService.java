package AlonsoProjectCLI.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDao {
    @Override
    public User[] getUsers() {
        File file = new File("src/AlonsoProjectCLI/users.csv");

        User[] users = new User[4];

        try {
            int index = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().trim().split(", ");
                users[index] = new User(split[0], split[1], UUID.fromString(split[2]));
                index++;
            }
            return users;

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


    }
}

