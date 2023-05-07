package AlonsoProjectCLI.User;
import java.util.UUID;

public class UserService {
    private UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public User[] viewAllUsers(){
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
