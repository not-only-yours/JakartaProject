package Servlets;

import Dao.InMemoryDatabase;
import Dao.TestUserDao;
import DaoInterface.DaoFactory;
import ServiceInterfaces.TenderService;
import ServiceInterfaces.UserService;
import Services.TenderServiceImpl;
import Services.UserServiceImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{
 
     @Override
    public void contextInitialized(ServletContextEvent sce) {

        
        InMemoryDatabase database = new InMemoryDatabase();
        
        TestUserDao.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();

        TenderService tenderService = new TenderServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("tenderService", tenderService);

        UserService userService = new UserServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("userService", userService);
        
        sce.getServletContext().setAttribute("allTenders", tenderService.getAllTenders());
        
        sce.getServletContext().setAttribute("allSearchTenders", tenderService.search(""));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

}
}
