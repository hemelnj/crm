/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.accounttype;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CRM_AccountTypes")
public class AccountType implements Serializable {
 private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    @NotNull
    @Column(name = "Name")
    private String mName;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.mId);
        hash = 83 * hash + Objects.hashCode(this.mName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountType other = (AccountType) obj;
        if (!Objects.equals(this.mId, other.mId)) {
            return false;
        }
        if (!Objects.equals(this.mName, other.mName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccountType{" + "mId=" + mId + ", mName=" + mName + '}';
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public AccountType() {
    }

    public AccountType(Long mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

}
