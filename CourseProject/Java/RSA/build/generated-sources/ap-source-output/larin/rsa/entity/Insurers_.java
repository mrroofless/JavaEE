package larin.rsa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.rsa.entity.Unfairlistofcars;
import larin.rsa.entity.Unfairlistofclients;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:28")
@StaticMetamodel(Insurers.class)
public class Insurers_ { 

    public static volatile SingularAttribute<Insurers, Integer> idInsurer;
    public static volatile SingularAttribute<Insurers, String> title;
    public static volatile SingularAttribute<Insurers, String> address;
    public static volatile CollectionAttribute<Insurers, Unfairlistofclients> unfairlistofclientsCollection;
    public static volatile CollectionAttribute<Insurers, Unfairlistofcars> unfairlistofcarsCollection;

}