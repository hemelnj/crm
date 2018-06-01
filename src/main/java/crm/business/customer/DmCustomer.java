/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.customer;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class DmCustomer {

    private Long mId;

    private String mName;

    private int mAge;

    private String mNid;

    private String mDob;

    private String mFathersName;

    private String mMaritialStatus;

    private String mAddress;
    private String mState;

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public DmCustomer(Long mId, String mName, int mAge, String mNid, String mDob, String mFathersName, String mMaritialStatus, String mAddress, String mState) {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.mId);
        hash = 79 * hash + Objects.hashCode(this.mName);
        hash = 79 * hash + this.mAge;
        hash = 79 * hash + Objects.hashCode(this.mNid);
        hash = 79 * hash + Objects.hashCode(this.mDob);
        hash = 79 * hash + Objects.hashCode(this.mFathersName);
        hash = 79 * hash + Objects.hashCode(this.mMaritialStatus);
        hash = 79 * hash + Objects.hashCode(this.mAddress);
        hash = 79 * hash + Objects.hashCode(this.mState);
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
        final DmCustomer other = (DmCustomer) obj;
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

   

    public DmCustomer() {
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

    public DmCustomer(Long mId, String mName, int mAge, String mNid, String mDob, String mFathersName, String mMaritialStatus, String mAddress) {
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
