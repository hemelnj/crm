/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.transactionledger;

import crm.data.account.Account;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CRM_TransactionLedgers")
public class TransactionLedger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;
    
    @NotNull
    @Column(name = "Prebalance")
    private double mPreBalance;
    
    @NotNull
    @Column(name = "Postbalance")
    private double mPostBalance;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", nullable = false)
    private Date mTimestamp;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.mId);
        hash = 79 * hash + Objects.hashCode(this.account);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.mPreBalance) ^ (Double.doubleToLongBits(this.mPreBalance) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.mPostBalance) ^ (Double.doubleToLongBits(this.mPostBalance) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.mTimestamp);
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
        final TransactionLedger other = (TransactionLedger) obj;
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
        return "TransactionLedger{" + "mId=" + mId + ", account=" + account + ", mPreBalance=" + mPreBalance + ", mPostBalance=" + mPostBalance + ", mTimestamp=" + mTimestamp + '}';
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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

    public TransactionLedger() {
    }

    public TransactionLedger(Long mId, Account account, double mPreBalance, double mPostBalance, Date mTimestamp) {
        this.mId = mId;
        this.account = account;
        this.mPreBalance = mPreBalance;
        this.mPostBalance = mPostBalance;
        this.mTimestamp = mTimestamp;
    }
    
}
