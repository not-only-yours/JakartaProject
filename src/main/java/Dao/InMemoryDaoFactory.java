
package Dao;


import DaoInterface.*;



class InMemoryDaoFactory implements DaoFactory {
     InMemoryDatabase database;

   UserDao userDao;
   TenderDao tenderDao;
    

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        tenderDao = new InMemoryTenderDao(database);
        
        userDao = new InMemoryUserDao(database);
    }

   
    @Override
    public TenderDao getTenderDao() {
        return tenderDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }


   
}
