
package Dao;
import DaoInterface.UserDao;
import Model.User;

class InMemoryUserDao extends InMemoryAbstractDao<User> implements UserDao {

    InMemoryUserDao(InMemoryDatabase database) {
        super(database.users, User::getUserId, User::setUserId, database);
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    
}
