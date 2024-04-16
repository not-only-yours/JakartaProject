
package ServiceInterfaces;
import Model.Tender;
import Model.User;
import java.util.Collection;

public interface TenderService {
    Collection<Tender> getAllTenders();
    
    Collection<Tender> search(String text);

    Collection<Tender> getTendersByUser(User user);

    Tender getTenderById(Integer tenderId);

    boolean getOpened(Tender tender);
    
    void addTender(String title, String description , User user);
    
    void deleteTender(Integer tenderId);
    
    void Open(Integer tenderId);
    
    void Close(Integer tenderId);
    
    void AddProp(User user, Integer tenderId);
    
    
}
