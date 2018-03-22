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
@Table(name = "unfairlistofclients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unfairlistofclients.findAll", query = "SELECT u FROM Unfairlistofclients u"),
    @NamedQuery(name = "Unfairlistofclients.findByIdClient", query = "SELECT u FROM Unfairlistofclients u WHERE u.idClient = :idClient"),
    @NamedQuery(name = "Unfairlistofclients.findBySurname", query = "SELECT u FROM Unfairlistofclients u WHERE u.surname = :surname"),
    @NamedQuery(name = "Unfairlistofclients.findByName", query = "SELECT u FROM Unfairlistofclients u WHERE u.name = :name"),
    @NamedQuery(name = "Unfairlistofclients.findByPatronymic", query = "SELECT u FROM Unfairlistofclients u WHERE u.patronymic = :patronymic"),
    @NamedQuery(name = "Unfairlistofclients.findByRatings", query = "SELECT u FROM Unfairlistofclients u WHERE u.ratings = :ratings"),
    @NamedQuery(name = "Unfairlistofclients.findByCrashes", query = "SELECT u FROM Unfairlistofclients u WHERE u.crashes = :crashes")})
public class Unfairlistofclients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Size(max = 20)
    @Column(name = "surname")
    private String surname;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "patronymic")
    private String patronymic;
    @Size(max = 10)
    @Column(name = "ratings")
    private String ratings;
    @Column(name = "crashes")
    private Integer crashes;
    @JoinColumn(name = "id_insurer", referencedColumnName = "id_insurer")
    @ManyToOne
    private Insurers idInsurer;

    public Unfairlistofclients() {
    }

    public Unfairlistofclients(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public Integer getCrashes() {
        return crashes;
    }

    public void setCrashes(Integer crashes) {
        this.crashes = crashes;
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
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unfairlistofclients)) {
            return false;
        }
        Unfairlistofclients other = (Unfairlistofclients) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.rsa.entity.Unfairlistofclients[ idClient=" + idClient + " ]";
    }
    
}
