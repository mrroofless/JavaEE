/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.dao;

import java.sql.SQLException;
import java.util.Collection;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import larin.main.entity.Calculation;
import larin.main.entity.Cars;
import larin.main.entity.Clients;
import larin.main.entity.Osago;

/**
 *
 * @author Учебный
 */
@Local
public interface IDAOLocal {

    void addCalculation(Calculation calcul) throws SQLException;

    void addCar(Cars c1) throws SQLException;

    void addClient(Clients c) throws SQLException;

    void addOsago(Osago os) throws SQLException;

    Collection<Calculation> getCalcByCarVinCode(String vinCode);

    Collection<Cars> getCarByClientId(Clients idClient);


    Clients getIdOfClient(String ratings) throws SQLException;
    
        void setCarss(Cars carss);
        Cars getCarByVinCode(String vinCode) throws SQLException;
         Osago getPolicyByCar(Cars vinCode) throws SQLException;
             Calculation getCalcIdByPolicy(Osago id_policy) throws SQLException;

    Calculation getTotalSumByCalcId(Calculation id_calc) throws SQLException;
    
     Clients getClientIdByEmail(String email) throws SQLException;

     Clients getClientByEmail(String email) throws SQLException;
     
    /**
     * @param cli the cli to set
     */
    void setCli(Clients cli);

    /**
     * @param em the em to set
     */
    void setEm(EntityManager em);
    
}
