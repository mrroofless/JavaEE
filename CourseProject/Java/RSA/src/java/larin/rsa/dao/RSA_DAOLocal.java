/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.dao;

import java.sql.SQLException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import larin.rsa.entity.*;

/**
 *
 * @author Учебный
 */
@Local
public interface RSA_DAOLocal {
    
        EntityManager getEm();

    void setEm(EntityManager em);

    Unfairlistofclients getClientByRatings(String ratings) throws SQLException;

    Unfairlistofcars getRiskFactorByByCar(String brand, String model) throws SQLException;
    
    
}
