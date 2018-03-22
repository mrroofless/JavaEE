/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.mbean;

import java.sql.SQLException;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ViewScoped;
import larin.main.dao.IDAOLocal;
import larin.main.entity.Calculation;
import larin.main.entity.Osago;
import larin.rsa.dao.RSA_DAOLocal;
import larin.rsa.entity.Unfairlistofclients;

/**
 *
 * @author Учебный
 */
@Stateful
@ViewScoped
public class InsuranceSFSB implements SFSBLocal {

        
        @EJB private IDAOLocal insuranceDAO;
        @EJB private RSA_DAOLocal rsaDAO;
        
        
    private double age_factor;
    private double exp_factor;
    private double power_factor;
    private double total_sum;
    
    private Osago policyId;
    private String clRat;
     private Calculation calc = new Calculation();
     
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String addCalcInDB() throws SQLException{
 double total_sum_predv = 100*getAge_factor() + 100*getExp_factor() + 100*getPower_factor() ;
    Calculation ca = new Calculation(); 
    ca.setIdPolicy(getPolicyId());
    ca.setTermOfInsurance(getCalc().getTermOfInsurance());
    ca.setTotalSum(getCalc().getTermOfInsurance()*total_sum_predv);
    
    getInsuranceDAO().addCalculation(ca);
    Unfairlistofclients clientByRatings = getRsaDAO().getClientByRatings(clRat);
    setTotal_sum(ca.getTotalSum());
    
    if (clientByRatings == null) {
        return "/Final.xhtml";
    }
    else {
        return "/BadParam.xhtml";
    }
    }
    /**
     * @return the insuranceDAO
     */
    @Override
    public IDAOLocal getInsuranceDAO() {
        return insuranceDAO;
    }

    /**
     * @param insuranceDAO the insuranceDAO to set
     */
    @Override
    public void setInsuranceDAO(IDAOLocal insuranceDAO) {
        this.insuranceDAO = insuranceDAO;
    }

    /**
     * @return the rsaDAO
     */
    @Override
    public RSA_DAOLocal getRsaDAO() {
        return rsaDAO;
    }

    /**
     * @param rsaDAO the rsaDAO to set
     */
    @Override
    public void setRsaDAO(RSA_DAOLocal rsaDAO) {
        this.rsaDAO = rsaDAO;
    }

    /**
     * @return the age_factor
     */
    @Override
    public double getAge_factor() {
        return age_factor;
    }

    /**
     * @param age_factor the age_factor to set
     */
    @Override
    public void setAge_factor(double age_factor) {
        this.age_factor = age_factor;
    }

    /**
     * @return the exp_factor
     */
    @Override
    public double getExp_factor() {
        return exp_factor;
    }

    /**
     * @param exp_factor the exp_factor to set
     */
    @Override
    public void setExp_factor(double exp_factor) {
        this.exp_factor = exp_factor;
    }

    /**
     * @return the power_factor
     */
    @Override
    public double getPower_factor() {
        return power_factor;
    }

    /**
     * @param power_factor the power_factor to set
     */
    @Override
    public void setPower_factor(double power_factor) {
        this.power_factor = power_factor;
    }

    /**
     * @return the total_sum
     */
    @Override
    public double getTotal_sum() {
        return total_sum;
    }

    /**
     * @param total_sum the total_sum to set
     */
    @Override
    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    /**
     * @return the policyId
     */
    @Override
    public Osago getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    @Override
    public void setPolicyId(Osago policyId) {
        this.policyId = policyId;
    }

    /**
     * @return the calc
     */
    @Override
    public Calculation getCalc() {
        return calc;
    }

    /**
     * @param calc the calc to set
     */
    public void setCalc(Calculation calc) {
        this.calc = calc;
    }

    /**
     * @return the clRat
     */
    @Override
    public String getClRat() {
        return clRat;
    }

    /**
     * @param clRat the clRat to set
     */
    @Override
    public void setClRat(String clRat) {
        this.clRat = clRat;
    }

    /**
     * @return the clRat
     */

}
