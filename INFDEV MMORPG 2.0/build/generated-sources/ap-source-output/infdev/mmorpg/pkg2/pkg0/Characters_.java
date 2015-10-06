package infdev.mmorpg.pkg2.pkg0;

import infdev.mmorpg.pkg2.pkg0.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-06T13:41:29")
@StaticMetamodel(Characters.class)
public class Characters_ { 

    public static volatile SingularAttribute<Characters, Integer> level;
    public static volatile SingularAttribute<Characters, String> class1;
    public static volatile SingularAttribute<Characters, String> name;
    public static volatile CollectionAttribute<Characters, Users> usersCollection;
    public static volatile SingularAttribute<Characters, String> race;

}