package infdev.mmorpg.pkg2.pkg0;

import infdev.mmorpg.pkg2.pkg0.Servers;
import infdev.mmorpg.pkg2.pkg0.StoresPK;
import infdev.mmorpg.pkg2.pkg0.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-09T16:23:17")
@StaticMetamodel(Stores.class)
public class Stores_ { 

    public static volatile SingularAttribute<Stores, Users> users;
    public static volatile SingularAttribute<Stores, StoresPK> storesPK;
    public static volatile SingularAttribute<Stores, Servers> servers;
    public static volatile SingularAttribute<Stores, Date> date;

}