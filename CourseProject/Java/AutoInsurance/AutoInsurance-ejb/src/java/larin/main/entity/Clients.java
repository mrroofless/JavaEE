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
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByIdClient", query = "SELECT c FROM Clients c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Clients.findBySurname", query = "SELECT c FROM Clients c WHERE c.surname = :surname"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByPatronymic", query = "SELECT c FROM Clients c WHERE c.patronymic = :patronymic"),
    @NamedQuery(name = "Clients.findByAddress", query = "SELECT c FROM Clients c WHERE c.address = :address"),
    @NamedQuery(name = "Clients.findByTelephone", query = "SELECT c FROM Clients c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByPassword", query = "SELECT c FROM Clients c WHERE c.password = :password"),
    @NamedQuery(name = "Clients.findByAge", query = "SELECT c FROM Clients c WHERE c.age = :age"),
    @NamedQuery(name = "Clients.findByExperience", query = "SELECT c FROM Clients c WHERE c.experience = :experience"),
    @NamedQuery(name = "Clients.findByRatings", query = "SELECT c FROM Clients c WHERE c.ratings = :ratings"),
    @NamedQuery(name = "Clients.findClientIdByEmail", query = "SELECT c.idClient FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByInsecure", query = "SELECT c FROM Clients c WHERE c.insecure = :insecure")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Size(max = 30)
    @Column(name = "surname")
    private String surname;
    @Size(max = 18)
    @Column(name = "name")
    private String name;
    @Size(max = 18)
    @Column(name = "patronymic")
    private String patronymic;
    @Size(max = 40)
    @Column(name = "address")
    private String address;
    @Size(max = 18)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 18)
    @Column(name = "email")
    private String email;
    @Size(max = 18)
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "experience")
    private Integer experience;
    @Size(max = 10)
    @Column(name = "ratings")
    private String ratings;
    @Column(name = "insecure")
    private Boolean insecure;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Cars> carsCollection;

    public Clients() {
    }

    public Clients(Integer idClient) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public Boolean getInsecure() {
        return insecure;
    }

    public void setInsecure(Boolean insecure) {
        this.insecure = insecure;
    }

    @XmlTransient
    public Collection<Cars> getCarsCollection() {
        return carsCollection;
    }

    public void setCarsCollection(Collection<Cars> carsCollection) {
        this.carsCollection = carsCollection;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "larin.main.entity.Clients[ idClient=" + idClient + " ]";
    }
    
}
