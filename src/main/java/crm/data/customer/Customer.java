/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.customer;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CRM_CUSTOMERS")
@NamedQueries({
    @NamedQuery(name = "customer.getAllCustomerByState", query = "SELECT g FROM Customer g where g.mState=:state")
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    @NotNull
    @Column(name = "Name")
    private String mName;

    @NotNull
    @Column(name = "Age")
    private int mAge;

    @NotNull
    @Column(name = "Nid")
    private String mNid;

    @NotNull
    @Column(name = "Dob")
    private String mDob;

    @NotNull
    @Column(name = "FathersName")
    private String mFathersName;

    @NotNull
    @Column(name = "MaritialStatus")
    private String mMaritialStatus;

    @NotNull
    @Column(name = "Address")
    private String mAddress;
    
    
    @NotNull
    @Column(name = "status")
    private String mState;

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public Long getmId() {
        return mId;
    }

    @Override
    public String toString() {
        return "Customer{" + "mId=" + mId + ", mName=" + mName + ", mAge=" + mAge + ", mNid=" + mNid + ", mDob=" + mDob + ", mFathersName=" + mFathersName + ", mMaritialStatus=" + mMaritialStatus + ", mAddress=" + mAddress + ", mState=" + mState + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.mId);
        hash = 43 * hash + Objects.hashCode(this.mName);
        hash = 43 * hash + this.mAge;
        hash = 43 * hash + Objects.hashCode(this.mNid);
        hash = 43 * hash + Objects.hashCode(this.mDob);
        hash = 43 * hash + Objects.hashCode(this.mFathersName);
        hash = 43 * hash + Objects.hashCode(this.mMaritialStatus);
        hash = 43 * hash + Objects.hashCode(this.mAddress);
        hash = 43 * hash + Objects.hashCode(this.mState);
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
        final Customer other = (Customer) obj;
        if (this.mAge != other.mAge) {
            return false;
        }
        if (!Objects.equals(this.mName, other.mName)) {
            return false;
        }
        if (!Objects.equals(this.mNid, other.mNid)) {
            return false;
        }
        if (!Objects.equals(this.mDob, other.mDob)) {
            return false;
        }
        if (!Objects.equals(this.mFathersName, other.mFathersName)) {
            return false;
        }
        if (!Objects.equals(this.mMaritialStatus, other.mMaritialStatus)) {
            return false;
        }
        if (!Objects.equals(this.mAddress, other.mAddress)) {
            return false;
        }
        if (!Objects.equals(this.mState, other.mState)) {
            return false;
        }
        if (!Objects.equals(this.mId, other.mId)) {
            return false;
        }
        return true;
    }

    public Customer(Long mId, String mName, int mAge, String mNid, String mDob, String mFathersName, String mMaritialStatus, String mAddress, String mState) {
        this.mId = mId;
        this.mName = mName;
        this.mAge = mAge;
        this.mNid = mNid;
        this.mDob = mDob;
        this.mFathersName = mFathersName;
        this.mMaritialStatus = mMaritialStatus;
        this.mAddress = mAddress;
        this.mState = mState;
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

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmNid() {
        return mNid;
    }

    public void setmNid(String mNid) {
        this.mNid = mNid;
    }

    public String getmDob() {
        return mDob;
    }

    public void setmDob(String mDob) {
        this.mDob = mDob;
    }

    public String getmFathersName() {
        return mFathersName;
    }

    public void setmFathersName(String mFathersName) {
        this.mFathersName = mFathersName;
    }

    public String getmMaritialStatus() {
        return mMaritialStatus;
    }

    public void setmMaritialStatus(String mMaritialStatus) {
        this.mMaritialStatus = mMaritialStatus;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Customer() {
    }

    public Customer(Long mId, String mName, int mAge, String mNid, String mDob, String mFathersName, String mMaritialStatus, String mAddress) {
        this.mId = mId;
        this.mName = mName;
        this.mAge = mAge;
        this.mNid = mNid;
        this.mDob = mDob;
        this.mFathersName = mFathersName;
        this.mMaritialStatus = mMaritialStatus;
        this.mAddress = mAddress;
    }

}
