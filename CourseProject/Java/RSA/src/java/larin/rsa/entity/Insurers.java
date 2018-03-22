/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package larin.rsa.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Учебный
 */
@Entity
@Table(name = "insurers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurers.findAll", query = "SELECT i FROM Insurers i"),
    @NamedQuery(name = "Insurers.findByIdInsurer", query = "SELECT i FROM Insurers i WHERE i.idInsurer = :idInsurer"),
    @NamedQuery(name = "Insurers.findByTitle", query = "SELECT i FROM Insurers i WHERE i.title = :title"),
    @NamedQuery(name = "Insurers.findByAddress", query = "SELECT i FROM Insurers i WHERE i.address = :address")})
public class Insurers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insurer")
    private Integer idInsurer;
    @Size(max = 40)
    @Column(name = "title")
    private String title;
    @Size(max = 40)
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "idInsurer")
    private Collection<Unfairlistofclients> unfairlistofclientsCollection;
    @OneToMany(mappedBy = "idInsurer")
    private Collection<Unfairlistofcars> unfairlistofcarsCollection;

    public Insurers() {
    }

    public Insurers(Integer idInsurer) {
        this.idInsurer = idInsurer;
    }

    public Integer getIdInsurer() {
        return idInsurer;
    }

    public void setIdInsurer(Integer idInsurer) {
        this.idInsurer = idInsurer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Unfairlistofclients> getUnfairlistofclientsCollection() {
        return unfairlistofclientsCollection;
    }

    public void setUnfairlistofclientsCollection(Collection<Unfairlistofclients> unfairlistofclientsCollection) {
        this.unfairlistofclientsCollection = unfairlistofclientsCollection;
    }

    @XmlTransient
    public Collection<Unfairlistofcars> getUnfairlistofcarsCollection() {
        return unfairlistofcarsCollection;
    }

    public void setUnfairlistofcarsCollection(Collection<Unfairlistofcars> unfairlistofcarsCollection) {
        this.unfairlistofcarsCollection = unfairlistofcarsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsurer != null ? idInsurer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurers)) {
            return false;
        }
        Insurers other = (Insurers) object;
        if ((this.idInsurer == null && other.idInsurer != null) || (this.idInsurer != null && !this.idInsurer.equals(other.idInsurer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.rsa.entity.Insurers[ idInsurer=" + idInsurer + " ]";
    }
    
}
