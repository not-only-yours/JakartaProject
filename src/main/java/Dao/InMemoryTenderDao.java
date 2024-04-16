
package Dao;


import Model.Tender;
import java.util.Collection;
import java.util.stream.*;
import DaoInterface.TenderDao;
import Model.User;

class InMemoryTenderDao extends InMemoryAbstractDao<Tender> implements TenderDao {
     InMemoryTenderDao(InMemoryDatabase database) {
        super(database.tenders, Tender::getTenderId,Tender::setTenderId, database);
    }

   
 
    @Override
    public Collection<Tender> findByText(String text) {
        String[] words = text.toLowerCase().split(" ");
        return database.tenders.values().stream()
                .filter(tender -> containsAllWords(tender, words))
                .collect(Collectors.toList());
    }

    private static boolean containsAllWords(Tender tender, String[] words) {
        String string = tender.getTitle() + " " + tender.getDescription();
        string = string.toLowerCase();
        return Stream.of(words).allMatch(string::contains);
       
    }
@Override
    public void addTender( User user, String text,String title) {
        
        Tender tender = new Tender( -1, title, text, user);
        this.insert(tender, true);

        }
@Override
    public void deleteTender(Integer tenderId){
    database.tenders.remove(tenderId);
    
    }
    
@Override
public boolean getOpened(Tender tender){
   return tender.isOpened();
}
    
   
    
}
