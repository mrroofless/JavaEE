/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.mbean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import larin.main.dao.IDAOLocal;
import larin.main.entity.*;
import larin.rsa.dao.RSA_DAOLocal;

/**
 *
 * @author Учебный
 */
@ManagedBean(name="insuranceMBean")
@Stateless
@Named
@TransactionManagement
public class InsuranceMBean implements Serializable {

    
    
    private Clients clientId=null;
    private Osago policyId=null;
    private Cars carVin=null;
    private Calculation calcId=null;
    private double total_sum=0;
    
    private double age_factor=0;
    private double exp_factor=0;
    private double power_factor=0;
    
    private Clients client = new Clients();
    private Cars c = new Cars();
    private Calculation calc = new Calculation();
    private Osago osago = new Osago();
    private Collection<Cars> carCollection;
    

    /**
     * Creates a new instance of InsuranceMBean
     */
    public InsuranceMBean() {
    }
    
        @EJB private IDAOLocal insuranceDAO;
        @EJB private RSA_DAOLocal rsaDAO;
        @EJB private SFSBLocal sfsbLocal;
    

        public String autorizat() throws SQLException{
        {   
            if((getClient().getEmail() != null) && (getClient().getEmail().equals(getClient().getEmail()))){
            Clients searchClient = getInsuranceDAO().getClientByEmail(getClient().getEmail());
            setClientId(getInsuranceDAO().getClientIdByEmail(getClient().getEmail()));
            /*
            Clients age = getInsuranceDAO().getClientIdByEmail((getClient().getEmail()));
            Clients exp = getInsuranceDAO().getClientIdByEmail((getClient().getEmail()));
        */
            if((searchClient.getPassword() != null) && (searchClient.getPassword().equals(getClient().getPassword()))) {
                         
                setClient(searchClient);
                            
                return "/Start.xhtml";
            }
            }return "/Error.xhtml";
    }
    }
        
    public String addClientInDB() throws SQLException {
        Clients cl = new Clients();
        cl.setSurname(client.getSurname());
        cl.setName(client.getName());
        cl.setPatronymic(client.getPatronymic());
        cl.setAddress(client.getAddress());
        cl.setTelephone(client.getTelephone());
        cl.setEmail(client.getEmail());
        cl.setPassword(client.getPassword());
        cl.setAge(client.getAge());
        cl.setExperience(client.getExperience());
        cl.setRatings(client.getRatings());
        cl.setInsecure(false);
        getInsuranceDAO().addClient(cl);
        getSfsbLocal().setClRat(cl.getRatings());
        if (client.getAge()<=22) {
            age_factor=2;
        } else if ((client.getAge()>22) && (client.getAge()<30)) {
            age_factor=1.5;
        } else if (client.getAge()>=30) {
            age_factor=1.2;
        }
        getSfsbLocal().setAge_factor(age_factor);
        if (client.getExperience()<=1) {
            exp_factor = 2;
        } else if ((client.getExperience()>1) && (client.getExperience()<=5)) {
             exp_factor = 1.5;
        } else if (client.getExperience()>5) {
            exp_factor = 1.1;
        }
        getSfsbLocal().setExp_factor(exp_factor);
        
        setClientId(insuranceDAO.getIdOfClient(client.getRatings()));
        cl = insuranceDAO.getIdOfClient(client.getRatings());
        insuranceDAO.setCli(cl);

        return "/Start.xhtml";
    }

    public void addFactors() {
                if (getC().getPower()<50) {
            power_factor=1.1;
        } else if ((getC().getPower()>=50) && (getC().getPower()<70)) {
            power_factor=1.2;
        } else if ((getC().getPower()>=70) && (getC().getPower()<90)) {
            power_factor=1.3;
        } else if ((getC().getPower()>=90) && (getC().getPower()<110)) {
            power_factor=1.6;
        } else if (getC().getPower()>=110) {
            power_factor=2;
        }
                getSfsbLocal().setPower_factor(power_factor);
    }
    public String addCarInDB() throws SQLException {
        Cars car = new Cars();
        car.setBrand(getC().getBrand());
        car.setModel(getC().getModel());
        car.setVinCode(getC().getVinCode());
        car.setReleaseDate(getC().getReleaseDate());
        car.setPower(getC().getPower());
        car.setIdClient(clientId);
        getInsuranceDAO().addCar(car);
        
        setCarVin(insuranceDAO.getCarByVinCode(getC().getVinCode()));
        
        addFactors();
        addOsagoInDB();
        return "/Inscount.xhtml";
    }
public void addOsagoInDB() throws SQLException {
    Osago o = new Osago();
    o.setAgeFactor(age_factor);
    o.setExpFactor(exp_factor);
    o.setPowerFactor(power_factor);
    o.setVinCode(carVin);
    getInsuranceDAO().addOsago(o);
    setPolicyId(insuranceDAO.getPolicyByCar(getCarVin()));
    getSfsbLocal().setPolicyId(insuranceDAO.getPolicyByCar(getCarVin()));
}

public String findCarsOfClient() {
    setCarCollection(insuranceDAO.getCarByClientId(clientId));
    return "/Cars.xhtml";
}

/*
public void checkAndCalc() throws SQLException {
    try {
         getSfsbLocal().addCalcInDB();
    }
    catch(Exception e) {
        
    } 
}
*/
    /**
     * @return the insuranceDAO
     */
    public IDAOLocal getInsuranceDAO() {
        return insuranceDAO;
    }

    /**
     * @param insuranceDAO the insuranceDAO to set
     */
    public void setInsuranceDAO(IDAOLocal insuranceDAO) {
        this.insuranceDAO = insuranceDAO;
    }

    /**
     * @return the client
     */
    public Clients getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Clients client) {
        this.client = client;
    }

    /**
     * @return the car
     */
    public Cars getCar() {
        return getC();
    }

    /**
     * @param car the car to set
     */
    public void setCar(Cars car) {
        this.setC(car);
    }

    /**
     * @return the calc
     */
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
     * @return the osago
     */
    public Osago getOsago() {
        return osago;
    }

    /**
     * @param osago the osago to set
     */
    public void setOsago(Osago osago) {
        this.osago = osago;
    }

    /**
     * @return the clientId
     */
    public Clients getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the c
     */
    public Cars getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cars c) {
        this.c = c;
    }

    /**
     * @return the age_factor
     */
    public double getAge_factor() {
        return age_factor;
    }

    /**
     * @param age_factor the age_factor to set
     */
    public void setAge_factor(double age_factor) {
        this.age_factor = age_factor;
    }

    /**
     * @return the exp_factor
     */
    public double getExp_factor() {
        return exp_factor;
    }

    /**
     * @param exp_factor the exp_factor to set
     */
    public void setExp_factor(double exp_factor) {
        this.exp_factor = exp_factor;
    }

    /**
     * @return the power_factor
     */
    public double getPower_factor() {
        return power_factor;
    }

    /**
     * @param power_factor the power_factor to set
     */
    public void setPower_factor(double power_factor) {
        this.power_factor = power_factor;
    }

    /**
     * @return the policyId
     */
    public Osago getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    public void setPolicyId(Osago policyId) {
        this.policyId = policyId;
    }

    /**
     * @return the carVin
     */
    public Cars getCarVin() {
        return carVin;
    }

    /**
     * @param carVin the carVin to set
     */
    public void setCarVin(Cars carVin) {
        this.carVin = carVin;
    }

    /**
     * @return the calcId
     */
    public Calculation getCalcId() {
        return calcId;
    }

    /**
     * @param calcId the calcId to set
     */
    public void setCalcId(Calculation calcId) {
        this.calcId = calcId;
    }

    /**
     * @return the total_sum
     */
    public double getTotal_sum() {
        return total_sum;
    }

    /**
     * @param total_sum the total_sum to set
     */
    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    /**
     * @return the clId
     */

    /**
     * @return the rsaDAO
     */
    public RSA_DAOLocal getRsaDAO() {
        return rsaDAO;
    }

    /**
     * @param rsaDAO the rsaDAO to set
     */
    public void setRsaDAO(RSA_DAOLocal rsaDAO) {
        this.rsaDAO = rsaDAO;
    }

    /**
     * @return the sfsbLocal
     */
    public SFSBLocal getSfsbLocal() {
        return sfsbLocal;
    }

    /**
     * @param sfsbLocal the sfsbLocal to set
     */
    public void setSfsbLocal(SFSBLocal sfsbLocal) {
        this.sfsbLocal = sfsbLocal;
    }

    /**
     * @return the carCollection
     */
    public Collection<Cars> getCarCollection() {
        return carCollection;
    }

    /**
     * @param carCollection the carCollection to set
     */
    public void setCarCollection(Collection<Cars> carCollection) {
        this.carCollection = carCollection;
    }



    /**
     * @return the total_sum
     */


    /**
     * @return the total_sum
     */

    /**
     * @return the carId
     */
    
}
