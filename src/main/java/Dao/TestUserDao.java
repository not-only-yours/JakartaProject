
package Dao;


import Model.Tender;
import Model.User;
import java.util.Arrays;
import java.util.List;


public class TestUserDao {
    public static void generateTo(InMemoryDatabase database) {
        database.users.clear();
        database.tenders.clear();
        
    
        User alice = new User(1, "Alice", "alice@example.com", "passwordhash");
        User bob = new User(2, "Bob", "bob@example.com", "passwordhash");
        User charlie = new User(3, "Charlie", "charlie@example.com", "passwordhash");
        User diana = new User(4, "Diana", "diana@example.com", "passwordhash");
        User evil = new User(5, "Evil Emperror", "evil@example.com", "passwordhash");
        List<User> users = Arrays.asList(alice, bob, charlie, diana, evil);
        users.forEach(user -> database.users.put(user.getUserId(), user));
        
        Tender tender1 = new Tender(1 ,"tender","jnvjfvjfj",alice);
        Tender tender2 = new Tender(2,"ghbn","jnvjfvjfj",bob);
        List<Tender> tenders = Arrays.asList(tender1,tender2);
        tenders.forEach(tender -> database.tenders.put(tender.getTenderId(),tender));
    }
}
