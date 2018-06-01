/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.transactionledger;

import crm.business.account.DmAccount;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class DmTransactionLedger {
    private Long mId;

    private DmAccount account;

    private double mPreBalance;

    private double mPostBalance;

    private Date mTimestamp;

    public DmTransactionLedger() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.mId);
        hash = 53 * hash + Objects.hashCode(this.account);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.mPreBalance) ^ (Double.doubleToLongBits(this.mPreBalance) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.mPostBalance) ^ (Double.doubleToLongBits(this.mPostBalance) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.mTimestamp);
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
        final DmTransactionLedger other = (DmTransactionLedger) obj;
        if (!Objects.equals(this.mId, other.mId)) {
            return false;
        }
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (Double.doubleToLongBits(this.mPreBalance) != Double.doubleToLongBits(other.mPreBalance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.mPostBalance) != Double.doubleToLongBits(other.mPostBalance)) {
            return false;
        }
        if (!Objects.equals(this.mTimestamp, other.mTimestamp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DmTransactionLedger{" + "mId=" + mId + ", account=" + account + ", mPreBalance=" + mPreBalance + ", mPostBalance=" + mPostBalance + ", mTimestamp=" + mTimestamp + '}';
    }

    public DmTransactionLedger(Long mId, DmAccount account, double mPreBalance, double mPostBalance, Date mTimestamp) {
        this.mId = mId;
        this.account = account;
        this.mPreBalance = mPreBalance;
        this.mPostBalance = mPostBalance;
        this.mTimestamp = mTimestamp;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public DmAccount getAccount() {
        return account;
    }

    public void setAccount(DmAccount account) {
        this.account = account;
    }

    public double getmPreBalance() {
        return mPreBalance;
    }

    public void setmPreBalance(double mPreBalance) {
        this.mPreBalance = mPreBalance;
    }

    public double getmPostBalance() {
        return mPostBalance;
    }

    public void setmPostBalance(double mPostBalance) {
        this.mPostBalance = mPostBalance;
    }

    public Date getmTimestamp() {
        return mTimestamp;
    }

    public void setmTimestamp(Date mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

}
