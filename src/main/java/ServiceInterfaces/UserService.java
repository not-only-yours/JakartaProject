package ServiceInterfaces;

import Model.User;

public interface UserService {
    
    User getByLogin(String login);

    boolean checkPassword(User user, String password);
    
    

}
