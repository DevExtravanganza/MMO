/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infdev.mmorpg.pkg2.pkg0;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roy van den Heuvel
 */
@Entity
@Table(name = "servers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servers.findAll", query = "SELECT s FROM Servers s"),
    @NamedQuery(name = "Servers.findByAddress", query = "SELECT s FROM Servers s WHERE s.address = :address"),
    @NamedQuery(name = "Servers.findByName", query = "SELECT s FROM Servers s WHERE s.name = :name"),
    @NamedQuery(name = "Servers.findByLocation", query = "SELECT s FROM Servers s WHERE s.location = :location"),
    @NamedQuery(name = "Servers.findByMaxUsers", query = "SELECT s FROM Servers s WHERE s.maxUsers = :maxUsers"),
    @NamedQuery(name = "Servers.findByConnectedUsers", query = "SELECT s FROM Servers s WHERE s.connectedUsers = :connectedUsers")})
public class Servers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "max_users")
    private Integer maxUsers;
    @Column(name = "connected_users")
    private Integer connectedUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servers")
    private Collection<Stores> storesCollection;

    public Servers() {
    }

    public Servers(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(Integer connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

    @XmlTransient
    public Collection<Stores> getStoresCollection() {
        return storesCollection;
    }

    public void setStoresCollection(Collection<Stores> storesCollection) {
        this.storesCollection = storesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (address != null ? address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servers)) {
            return false;
        }
        Servers other = (Servers) object;
        if ((this.address == null && other.address != null) || (this.address != null && !this.address.equals(other.address))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infdev.mmorpg.pkg2.pkg0.Servers[ address=" + address + " ]";
    }
    
}
