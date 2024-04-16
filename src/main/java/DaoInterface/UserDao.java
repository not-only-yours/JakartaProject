
package DaoInterface;

import Model.User;

public interface UserDao {
    
    User getByLogin(String login);

}
