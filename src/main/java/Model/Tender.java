
package Model;

import java.util.HashSet;
import java.util.Set;


public class Tender {
   
    private  Integer tenderId;
    private  String title;
    private  String description;
    private boolean opened;
    private Set<User> props;
    User user;
    
    public Tender(Integer tenderId,String title , String description  , User user){
        this.user = user;
        this.title = title;
        this.description = description;
        this.tenderId = tenderId;
        this.opened=true;
        this.props = new HashSet<>();
    }
   
public Integer getTenderId(){return tenderId;}

public void setTenderId(Integer tenderId){this.tenderId = tenderId;}

public String getTitle(){return title;}

public void setTitle(String title){this.title = title;}

public String getDescription(){return description;}

public void setDescription(String description){this.description = description;}

public boolean isOpened() {return opened;}

public void setOpened(boolean opened) {this.opened = opened;}

public User getUser(){return user;}

public void setUser(User user){this.user = user;}

    public Set<User> getProps() {
        return props;
    }

    public void setProps(Set<User> props) {
        this.props = props;
    }


}
