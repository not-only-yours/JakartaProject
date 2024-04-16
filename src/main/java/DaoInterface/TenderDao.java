
package DaoInterface;

import Model.Tender;
import java.util.Collection;
import Model.User;

public interface TenderDao  {
    
     Collection<Tender> findByText(String text);
     
     void addTender(User user,String text,String title);
     
     void deleteTender(Integer tenderId);
     
    boolean getOpened(Tender tender);

    public Tender get(Integer tenderId);

    public Collection<Tender> findAll();
    
}
