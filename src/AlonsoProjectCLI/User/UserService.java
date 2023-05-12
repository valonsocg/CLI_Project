package AlonsoProjectCLI.User;
import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> viewAllUsers(){
        return userDao.getUsers();

    }
    public User getUserById(UUID id){
        for (User user: viewAllUsers()) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
