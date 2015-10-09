/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infdev.mmorpg.pkg2.pkg0;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Roy van den Heuvel
 */
@Entity
@Table(name = "stores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s"),
    @NamedQuery(name = "Stores.findByServerAddress", query = "SELECT s FROM Stores s WHERE s.storesPK.serverAddress = :serverAddress"),
    @NamedQuery(name = "Stores.findByUserName", query = "SELECT s FROM Stores s WHERE s.storesPK.userName = :userName")})
public class Stores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StoresPK storesPK;
    
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "server_address", referencedColumnName = "address", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servers servers;

    public Stores() {
    }

    public Stores(StoresPK storesPK) {
        this.storesPK = storesPK;
    }

    public Stores(String serverAddress, String userName) {
        this.storesPK = new StoresPK(serverAddress, userName);
    }

    public StoresPK getStoresPK() {
        return storesPK;
    }

    public void setStoresPK(StoresPK storesPK) {
        this.storesPK = storesPK;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Servers getServers() {
        return servers;
    }

    public void setServers(Servers servers) {
        this.servers = servers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storesPK != null ? storesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.storesPK == null && other.storesPK != null) || (this.storesPK != null && !this.storesPK.equals(other.storesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infdev.mmorpg.pkg2.pkg0.Stores[ storesPK=" + storesPK + " ]";
    }
    
}
