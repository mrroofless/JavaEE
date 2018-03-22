package larin.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.main.entity.Cars;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:26")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile CollectionAttribute<Clients, Cars> carsCollection;
    public static volatile SingularAttribute<Clients, String> surname;
    public static volatile SingularAttribute<Clients, String> password;
    public static volatile SingularAttribute<Clients, String> patronymic;
    public static volatile SingularAttribute<Clients, Boolean> insecure;
    public static volatile SingularAttribute<Clients, String> address;
    public static volatile SingularAttribute<Clients, String> email;
    public static volatile SingularAttribute<Clients, String> name;
    public static volatile SingularAttribute<Clients, Integer> age;
    public static volatile SingularAttribute<Clients, Integer> idClient;
    public static volatile SingularAttribute<Clients, Integer> experience;
    public static volatile SingularAttribute<Clients, String> telephone;
    public static volatile SingularAttribute<Clients, String> ratings;

}