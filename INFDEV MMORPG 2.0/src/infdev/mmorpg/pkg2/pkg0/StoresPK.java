/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infdev.mmorpg.pkg2.pkg0;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Roy van den Heuvel
 */
@Embeddable
public class StoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "server_address")
    private String serverAddress;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;

    public StoresPK() {
    }

    public StoresPK(String serverAddress, String userName) {
        this.serverAddress = serverAddress;
        this.userName = userName;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverAddress != null ? serverAddress.hashCode() : 0);
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoresPK)) {
            return false;
        }
        StoresPK other = (StoresPK) object;
        if ((this.serverAddress == null && other.serverAddress != null) || (this.serverAddress != null && !this.serverAddress.equals(other.serverAddress))) {
            return false;
        }
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infdev.mmorpg.pkg2.pkg0.StoresPK[ serverAddress=" + serverAddress + ", userName=" + userName + " ]";
    }
    
}
