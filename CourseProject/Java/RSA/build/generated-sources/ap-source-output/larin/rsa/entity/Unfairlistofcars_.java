package larin.rsa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.rsa.entity.Insurers;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:28")
@StaticMetamodel(Unfairlistofcars.class)
public class Unfairlistofcars_ { 

    public static volatile SingularAttribute<Unfairlistofcars, Insurers> idInsurer;
    public static volatile SingularAttribute<Unfairlistofcars, String> model;
    public static volatile SingularAttribute<Unfairlistofcars, Integer> idCar;
    public static volatile SingularAttribute<Unfairlistofcars, String> reason;
    public static volatile SingularAttribute<Unfairlistofcars, String> brand;
    public static volatile SingularAttribute<Unfairlistofcars, Integer> riskFactor;

}