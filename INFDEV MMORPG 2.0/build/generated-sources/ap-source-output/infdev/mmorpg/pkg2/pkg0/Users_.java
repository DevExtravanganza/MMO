package infdev.mmorpg.pkg2.pkg0;

import infdev.mmorpg.pkg2.pkg0.Characters;
import infdev.mmorpg.pkg2.pkg0.Servers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-06T13:41:29")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Date> lastPayment;
    public static volatile SingularAttribute<Users, Integer> balance;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile CollectionAttribute<Users, Characters> charactersCollection;
    public static volatile CollectionAttribute<Users, Servers> serversCollection;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, Integer> monthsPaid;
    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> characterSlots;
    public static volatile SingularAttribute<Users, Boolean> banned;
    public static volatile SingularAttribute<Users, String> iban;

}