
package Services;

import ServiceInterfaces.TenderService;

import java.util.*;
import java.util.stream.Collectors;
import DaoInterface.DaoFactory;
import Model.Tender;
import Model.User;


public class TenderServiceImpl implements TenderService {

    DaoFactory daoFactory;

    public TenderServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Tender getTenderById(Integer tenderId) {
        return daoFactory.getTenderDao().get(tenderId);
    }

    @Override
    public void addTender(String title, String description, User user) {
        daoFactory.getTenderDao().addTender(user, description, title);
    }

    @Override
    public Collection<Tender> getAllTenders() {
        return daoFactory.getTenderDao().findAll();
    }

    @Override
    public void Close(Integer tenderId) {
        daoFactory.getTenderDao().get(tenderId).setOpened(false);
    }

    @Override
    public void Open(Integer tenderId) {
        daoFactory.getTenderDao().get(tenderId).setOpened(true);
    }

    @Override
    public Collection<Tender> search(String text) {
        if (text == null || text.equals("")) {
            return getAllTenders();
        }
        return daoFactory.getTenderDao().findByText(text);
    }

    @Override
    public void deleteTender(Integer tenderId) {

        daoFactory.getTenderDao().deleteTender(tenderId);

    }

    @Override
    public Collection<Tender> getTendersByUser(User user) {
        Collection<Tender> allTenders = getAllTenders();
        List<Tender> tendersByUser = new LinkedList<>();
        if (allTenders.isEmpty()) {
            return null;
        }
        allTenders.stream().filter((tender) -> (tender.getUser().equals(user))).forEachOrdered((tender) -> {
            tendersByUser.add(tender);
        });
        return tendersByUser;
    }

    @Override
    public void AddProp(User user, Integer tenderId) {
        daoFactory.getTenderDao().get(tenderId).getProps().add(user);
        
      
    }
    
    @Override
    public boolean getOpened(Tender tender){
    return daoFactory.getTenderDao().getOpened(tender);}
}
