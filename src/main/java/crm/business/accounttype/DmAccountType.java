/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.accounttype;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class DmAccountType {

    private Long mId;
    private String mName;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.mId);
        hash = 37 * hash + Objects.hashCode(this.mName);
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
        final DmAccountType other = (DmAccountType) obj;
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
        return "DmAccountType{" + "mId=" + mId + ", mName=" + mName + '}';
    }

    public DmAccountType() {
    }

    public DmAccountType(Long mId, String mName) {
        this.mId = mId;
        this.mName = mName;
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

}
