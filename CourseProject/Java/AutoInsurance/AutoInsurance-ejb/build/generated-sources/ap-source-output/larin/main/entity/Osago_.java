package larin.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import larin.main.entity.Calculation;
import larin.main.entity.Cars;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-16T20:51:26")
@StaticMetamodel(Osago.class)
public class Osago_ { 

    public static volatile SingularAttribute<Osago, Double> expFactor;
    public static volatile CollectionAttribute<Osago, Calculation> calculationCollection;
    public static volatile SingularAttribute<Osago, Integer> idPolicy;
    public static volatile SingularAttribute<Osago, Double> powerFactor;
    public static volatile SingularAttribute<Osago, Cars> vinCode;
    public static volatile SingularAttribute<Osago, Double> ageFactor;

}