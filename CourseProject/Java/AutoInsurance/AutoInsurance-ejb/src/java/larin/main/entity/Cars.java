/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.main.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Учебный
 */
@Entity
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findByVinCode", query = "SELECT c FROM Cars c WHERE c.vinCode = :vinCode"),
    @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByPower", query = "SELECT c FROM Cars c WHERE c.power = :power"),
    @NamedQuery(name = "Cars.findAllCarsByIdClient", query = "SELECT c FROM Cars c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Cars.findByReleaseDate", query = "SELECT c FROM Cars c WHERE c.releaseDate = :releaseDate")})
public class Cars implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "vin_code")
    private String vinCode;
    @Size(max = 18)
    @Column(name = "brand")
    private String brand;
    @Size(max = 18)
    @Column(name = "model")
    private String model;
    @Column(name = "power")
    private Integer power;
    @Column(name = "release_date")
    private Integer releaseDate;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Clients idClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vinCode")
    private Collection<Osago> osagoCollection;

    public Cars() {
    }

    public Cars(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    @XmlTransient
    public Collection<Osago> getOsagoCollection() {
        return osagoCollection;
    }

    public void setOsagoCollection(Collection<Osago> osagoCollection) {
        this.osagoCollection = osagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vinCode != null ? vinCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.vinCode == null && other.vinCode != null) || (this.vinCode != null && !this.vinCode.equals(other.vinCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.main.entity.Cars[ vinCode=" + vinCode + " ]";
    }
    
}
