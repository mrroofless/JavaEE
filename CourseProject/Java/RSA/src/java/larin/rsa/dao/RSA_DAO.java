/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.dao;

import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import larin.rsa.entity.Unfairlistofcars;
import larin.rsa.entity.Unfairlistofclients;

/**
 *
 * @author Учебный
 */
@Stateless
@LocalBean
public class RSA_DAO implements RSA_DAOLocal {

@PersistenceContext(unitName="RSAPU")

private EntityManager em;


    
    @Override 
   public Unfairlistofclients getClientByRatings(String Ratings) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Unfairlistofclients.findByRatings");
       query.setParameter("ratings", Ratings);
       return (Unfairlistofclients) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
    
 
    @Override
   public Unfairlistofcars getRiskFactorByByCar(String brand, String model) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("UnfairListOfCars.findRiskFactorByCar");
       query.setParameter("brand", brand);
       query.setParameter("model", model);
       return (Unfairlistofcars) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    } 

    /**
     * @return the em
     */
    @Override
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }


}
