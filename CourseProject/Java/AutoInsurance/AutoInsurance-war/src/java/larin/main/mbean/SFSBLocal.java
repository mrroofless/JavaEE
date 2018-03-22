/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.mbean;

import java.sql.SQLException;
import javax.ejb.Local;
import larin.main.dao.IDAOLocal;
import larin.main.entity.Calculation;
import larin.main.entity.Osago;
import larin.rsa.dao.RSA_DAOLocal;

/**
 *
 * @author Учебный
 */
@Local
public interface SFSBLocal {

    String addCalcInDB() throws SQLException;

    /**
     * @return the age_factor
     */
    double getAge_factor();

    /**
     * @return the exp_factor
     */
    double getExp_factor();

    /**
     * @return the insuranceDAO
     */
    IDAOLocal getInsuranceDAO();

    /**
     * @return the policyId
     */
    Osago getPolicyId();

    /**
     * @return the power_factor
     */
    double getPower_factor();

    /**
     * @return the rsaDAO
     */
    RSA_DAOLocal getRsaDAO();

    /**
     * @return the total_sum
     */
    double getTotal_sum();

    /**
     * @param age_factor the age_factor to set
     */
    void setAge_factor(double age_factor);

    /**
     * @param exp_factor the exp_factor to set
     */
    void setExp_factor(double exp_factor);

    /**
     * @param insuranceDAO the insuranceDAO to set
     */
    void setInsuranceDAO(IDAOLocal insuranceDAO);

    /**
     * @param policyId the policyId to set
     */
    void setPolicyId(Osago policyId);

    /**
     * @param power_factor the power_factor to set
     */
    void setPower_factor(double power_factor);

    /**
     * @param rsaDAO the rsaDAO to set
     */
    void setRsaDAO(RSA_DAOLocal rsaDAO);

    /**
     * @param total_sum the total_sum to set
     */
    void setTotal_sum(double total_sum);
    
     Calculation getCalc();
     
     String getClRat();
     
     void setClRat(String clRat);
    
}
