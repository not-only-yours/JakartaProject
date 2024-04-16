package DaoInterface;

public interface DaoFactory {
    
    TenderDao getTenderDao();

    UserDao getUserDao();   
}
