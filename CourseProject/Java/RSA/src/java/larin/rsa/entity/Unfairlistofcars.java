/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Учебный
 */
@Entity
@Table(name = "unfairlistofcars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unfairlistofcars.findAll", query = "SELECT u FROM Unfairlistofcars u"),
    @NamedQuery(name = "Unfairlistofcars.findByIdCar", query = "SELECT u FROM Unfairlistofcars u WHERE u.idCar = :idCar"),
    @NamedQuery(name = "Unfairlistofcars.findByBrand", query = "SELECT u FROM Unfairlistofcars u WHERE u.brand = :brand"),
    @NamedQuery(name = "Unfairlistofcars.findByModel", query = "SELECT u FROM Unfairlistofcars u WHERE u.model = :model"),
    @NamedQuery(name = "Unfairlistofcars.findByReason", query = "SELECT u FROM Unfairlistofcars u WHERE u.reason = :reason"),
    @NamedQuery(name = "Unfairlistofcars.findByRiskFactor", query = "SELECT u FROM Unfairlistofcars u WHERE u.riskFactor = :riskFactor")})
public class Unfairlistofcars implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_car")
    private Integer idCar;
    @Size(max = 20)
    @Column(name = "brand")
    private String brand;
    @Size(max = 20)
    @Column(name = "model")
    private String model;
    @Size(max = 40)
    @Column(name = "reason")
    private String reason;
    @Column(name = "risk_factor")
    private Integer riskFactor;
    @JoinColumn(name = "id_insurer", referencedColumnName = "id_insurer")
    @ManyToOne
    private Insurers idInsurer;

    public Unfairlistofcars() {
    }

    public Unfairlistofcars(Integer idCar) {
        this.idCar = idCar;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(Integer riskFactor) {
        this.riskFactor = riskFactor;
    }

    public Insurers getIdInsurer() {
        return idInsurer;
    }

    public void setIdInsurer(Insurers idInsurer) {
        this.idInsurer = idInsurer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCar != null ? idCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unfairlistofcars)) {
            return false;
        }
        Unfairlistofcars other = (Unfairlistofcars) object;
        if ((this.idCar == null && other.idCar != null) || (this.idCar != null && !this.idCar.equals(other.idCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.rsa.entity.Unfairlistofcars[ idCar=" + idCar + " ]";
    }
    
}
