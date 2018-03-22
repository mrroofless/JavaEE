/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.dao;

import java.sql.SQLException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import larin.main.entity.*;

/**
 *
 * @author Учебный
 */
@Stateless
@LocalBean
public class InsuranceDAO implements IDAOLocal {

@PersistenceContext(unitName="AutoInsurance-ejbPU")

    private EntityManager em;

    private Clients cli;
    private Cars carss;
        


    @Override
     public void addClient(Clients c) throws SQLException{
         
         getEm().persist(c);
         //em.flush();
    }
    
    @Override
    public Clients getIdOfClient(String ratings) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Clients.findByRatings");
       query.setParameter("ratings", ratings);
       return (Clients) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
    
        
    @Override
    public Clients getClientByEmail(String email) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Clients.findByEmail");
       query.setParameter("email", email);
       return (Clients) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
        
        @Override
    public Clients getClientIdByEmail(String email) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Clients.findByEmail");
       query.setParameter("email", email);
       return (Clients) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }

            public Clients getClientAgeByEmail(String email) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Clients.findByEmail");
       query.setParameter("email", email);
       return (Clients) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
            
    @Override
     public void addCar(Cars c1) throws SQLException{
         
         Cars car = new Cars();
         
         car.setVinCode(c1.getVinCode());
         car.setBrand(c1.getBrand());
         car.setModel(c1.getModel());
         car.setPower(car.getPower());
         car.setReleaseDate(c1.getReleaseDate());
         car.setIdClient(c1.getIdClient());
         getEm().persist(c1);
    }
    
    @Override
        public Cars getCarByVinCode(String vinCode) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Cars.findByVinCode");
       query.setParameter("vinCode", vinCode);
       return (Cars) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
        
    @Override
    public Collection<Cars> getCarByClientId (Clients idClient) {
   try {
       Query query = getEm().createNamedQuery("Cars.findAllCarsByIdClient");
       query.setParameter("idClient", idClient);
       return query.getResultList();
   } 
   catch (NoResultException e) {
       return null;
   }
}
    
    @Override
 public void addOsago(Osago os)    throws SQLException {
     
     Osago osago = new Osago();
     
     osago.setAgeFactor(os.getAgeFactor());
     osago.setExpFactor(os.getExpFactor());
     osago.setPowerFactor(os.getPowerFactor());
     osago.setVinCode(os.getVinCode());
        getEm().persist(osago);
 }
 
    @Override
            public Osago getPolicyByCar(Cars vinCode) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Osago.findByVinCode");
       query.setParameter("vinCode", vinCode);
       return (Osago) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
/*
 public void addKasko(Kasko ka) throws SQLException {
     
     Kasko kasko = new Kasko();
     
     kasko.setAntitheftAlarm(ka.getAntitheftAlarm());
     kasko.setDeductible(ka.getDeductible());
     kasko.setRiskType(ka.getRiskType());
     kasko.setAgeFactor(ka.getAgeFactor());
     kasko.setExpFactor(ka.getExpFactor());
     kasko.setPowerFactor(ka.getPowerFactor());
     kasko.setRiskFactor(ka.getRiskFactor());
 }
*/ 
 
    @Override
    public void addCalculation (Calculation calcul) throws SQLException {
    
    Calculation calc = new Calculation();
    calc.setIdPolicy(calcul.getIdPolicy());
    calc.setTermOfInsurance(calcul.getTermOfInsurance());
    calc.setTotalSum(calcul.getTotalSum());
        getEm().persist(calc);
    
}

        public void addCalculation1 (Calculation calcul, Osago os) throws SQLException {
    
    Calculation calc = new Calculation();
    calc.setIdPolicy(os);
    calc.setTermOfInsurance(calcul.getTermOfInsurance());
    calc.setTotalSum(calcul.getTotalSum());
        getEm().persist(calc);
    
}

    @Override
    public Collection<Calculation> getCalcByCarVinCode (String vinCode) {
   try {
       Query query = getEm().createNamedQuery("Calculation.findCalcByVinCode");
       query.setParameter("vinCode", vinCode);
       return query.getResultList();
   } 
   catch (NoResultException e) {
       return null;
   }
}
    @Override
            public Calculation getCalcIdByPolicy(Osago idPolicy) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Calculation.findCalcByIdPolicy");
       query.setParameter("idPolicy", idPolicy);
       return (Calculation) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
    @Override
                public Calculation getTotalSumByCalcId(Calculation idCalc) throws SQLException {
        try {
           Query query = getEm().createNamedQuery("Calculation.findTotalSumByIdCalc");
       query.setParameter("idCalc", idCalc);
       return (Calculation) query.getSingleResult();
   } 
   catch (NoResultException e) {
       return null; 
        }
    }
    /**
     * @return the em
     */
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

    /**
     * @return the cli
     */
    public Clients getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    @Override
    public void setCli(Clients cli) {
        this.cli = cli;
    }

    /**
     * @return the carss
     */
    public Cars getCarss() {
        return carss;
    }

    /**
     * @param carss the carss to set
     */
    @Override
    public void setCarss(Cars carss) {
        this.carss = carss;
    }

}
