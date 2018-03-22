package larin.rsa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.rsa.entity.Insurers;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:28")
@StaticMetamodel(Unfairlistofclients.class)
public class Unfairlistofclients_ { 

    public static volatile SingularAttribute<Unfairlistofclients, Insurers> idInsurer;
    public static volatile SingularAttribute<Unfairlistofclients, String> name;
    public static volatile SingularAttribute<Unfairlistofclients, Integer> idClient;
    public static volatile SingularAttribute<Unfairlistofclients, String> surname;
    public static volatile SingularAttribute<Unfairlistofclients, Integer> crashes;
    public static volatile SingularAttribute<Unfairlistofclients, String> ratings;
    public static volatile SingularAttribute<Unfairlistofclients, String> patronymic;

}