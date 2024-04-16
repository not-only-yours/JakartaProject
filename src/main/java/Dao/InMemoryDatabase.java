
package Dao;

import Model.Tender;
import Model.User;
import java.util.*;
import DaoInterface.DaoFactory;

public class InMemoryDatabase {
    
    Map<Integer, Tender> tenders;
    
    Map<Integer, User> users;

    public InMemoryDatabase() {
        tenders = new TreeMap<>();
        
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }
    
}
