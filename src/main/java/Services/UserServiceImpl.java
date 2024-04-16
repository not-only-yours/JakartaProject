
package Services;

import DaoInterface.DaoFactory;
import Model.User;
import ServiceInterfaces.UserService;

public class UserServiceImpl implements UserService{

    DaoFactory daoFactory;
    
    public UserServiceImpl(DaoFactory dao) {
        this.daoFactory = dao;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
    
}
