/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.data.user;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import olcm.data.role.Roles;

/**
 *
 * @author shamim
 */
@Entity
@Table(name = "auth_user")
@NamedQueries({
    @NamedQuery(name = "user.getroleId", query = "SELECT r.id from User u, Roles r where u.role.id=r.id and u.mUsername=:username and u.mPassword=:password")
})
public class User implements Serializable {

    public User() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    @NotNull
    @Column(name = "username")
    private String mUsername;

    @NotNull
    @Column(name = "password")
    private String mPassword;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Roles role;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public User(Long mId, String mUsername, String mPassword, Roles role) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "mId=" + mId + ", mUsername=" + mUsername + ", mPassword=" + mPassword + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.mId);
        hash = 37 * hash + Objects.hashCode(this.mUsername);
        hash = 37 * hash + Objects.hashCode(this.mPassword);
        hash = 37 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.mUsername, other.mUsername)) {
            return false;
        }
        if (!Objects.equals(this.mPassword, other.mPassword)) {
            return false;
        }
        if (!Objects.equals(this.mId, other.mId)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }
    
    
}
