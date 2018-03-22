/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Учебный
 */
@Entity
@Table(name = "calculation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculation.findAll", query = "SELECT c FROM Calculation c"),
    @NamedQuery(name = "Calculation.findByIdCalc", query = "SELECT c FROM Calculation c WHERE c.idCalc = :idCalc"),
    @NamedQuery(name = "Calculation.findByTermOfInsurance", query = "SELECT c FROM Calculation c WHERE c.termOfInsurance = :termOfInsurance"),
    @NamedQuery(name = "Calculation.findByTotalSum", query = "SELECT c FROM Calculation c WHERE c.totalSum = :totalSum")})
public class Calculation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calc")
    private Integer idCalc;
    @Column(name = "term_of_insurance")
    private Integer termOfInsurance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_sum")
    private Double totalSum;
    @JoinColumn(name = "id_policy", referencedColumnName = "id_policy")
    @ManyToOne
    private Osago idPolicy;

    public Calculation() {
    }

    public Calculation(Integer idCalc) {
        this.idCalc = idCalc;
    }

    public Integer getIdCalc() {
        return idCalc;
    }

    public void setIdCalc(Integer idCalc) {
        this.idCalc = idCalc;
    }

    public Integer getTermOfInsurance() {
        return termOfInsurance;
    }

    public void setTermOfInsurance(Integer termOfInsurance) {
        this.termOfInsurance = termOfInsurance;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Osago getIdPolicy() {
        return idPolicy;
    }

    public void setIdPolicy(Osago idPolicy) {
        this.idPolicy = idPolicy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalc != null ? idCalc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculation)) {
            return false;
        }
        Calculation other = (Calculation) object;
        if ((this.idCalc == null && other.idCalc != null) || (this.idCalc != null && !this.idCalc.equals(other.idCalc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.main.entity.Calculation[ idCalc=" + idCalc + " ]";
    }
    
}
