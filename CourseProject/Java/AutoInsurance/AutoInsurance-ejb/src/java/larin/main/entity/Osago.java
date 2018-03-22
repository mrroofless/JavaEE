/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Учебный
 */
@Entity
@Table(name = "osago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osago.findAll", query = "SELECT o FROM Osago o"),
    @NamedQuery(name = "Osago.findByIdPolicy", query = "SELECT o FROM Osago o WHERE o.idPolicy = :idPolicy"),
    @NamedQuery(name = "Osago.findByVinCode", query = "SELECT o FROM Osago o WHERE o.vinCode = :vinCode"),
    @NamedQuery(name = "Osago.findByAgeFactor", query = "SELECT o FROM Osago o WHERE o.ageFactor = :ageFactor"),
    @NamedQuery(name = "Osago.findByExpFactor", query = "SELECT o FROM Osago o WHERE o.expFactor = :expFactor"),
    @NamedQuery(name = "Osago.findByPowerFactor", query = "SELECT o FROM Osago o WHERE o.powerFactor = :powerFactor")})
public class Osago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_policy")
    private Integer idPolicy;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "age_factor")
    private Double ageFactor;
    @Column(name = "exp_factor")
    private Double expFactor;
    @Column(name = "power_factor")
    private Double powerFactor;
    @OneToMany(mappedBy = "idPolicy")
    private Collection<Calculation> calculationCollection;
    @JoinColumn(name = "vin_code", referencedColumnName = "vin_code")
    @ManyToOne(optional = false)
    private Cars vinCode;

    public Osago() {
    }

    public Osago(Integer idPolicy) {
        this.idPolicy = idPolicy;
    }

    public Integer getIdPolicy() {
        return idPolicy;
    }

    public void setIdPolicy(Integer idPolicy) {
        this.idPolicy = idPolicy;
    }

    public Double getAgeFactor() {
        return ageFactor;
    }

    public void setAgeFactor(Double ageFactor) {
        this.ageFactor = ageFactor;
    }

    public Double getExpFactor() {
        return expFactor;
    }

    public void setExpFactor(Double expFactor) {
        this.expFactor = expFactor;
    }

    public Double getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Double powerFactor) {
        this.powerFactor = powerFactor;
    }

    @XmlTransient
    public Collection<Calculation> getCalculationCollection() {
        return calculationCollection;
    }

    public void setCalculationCollection(Collection<Calculation> calculationCollection) {
        this.calculationCollection = calculationCollection;
    }

    public Cars getVinCode() {
        return vinCode;
    }

    public void setVinCode(Cars vinCode) {
        this.vinCode = vinCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPolicy != null ? idPolicy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osago)) {
            return false;
        }
        Osago other = (Osago) object;
        if ((this.idPolicy == null && other.idPolicy != null) || (this.idPolicy != null && !this.idPolicy.equals(other.idPolicy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.main.entity.Osago[ idPolicy=" + idPolicy + " ]";
    }
    
}
