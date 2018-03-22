package larin.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.main.entity.Clients;
import larin.main.entity.Osago;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:26")
@StaticMetamodel(Cars.class)
public class Cars_ { 

    public static volatile SingularAttribute<Cars, String> model;
    public static volatile SingularAttribute<Cars, Integer> releaseDate;
    public static volatile SingularAttribute<Cars, String> vinCode;
    public static volatile SingularAttribute<Cars, String> brand;
    public static volatile SingularAttribute<Cars, Integer> power;
    public static volatile SingularAttribute<Cars, Clients> idClient;
    public static volatile CollectionAttribute<Cars, Osago> osagoCollection;

}