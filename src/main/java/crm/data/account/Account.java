/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.account;

import crm.data.accounttype.AccountType;
import crm.data.customer.Customer;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CRM_Accounts")
public class Account implements Serializable {
 private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;

    @NotNull
    @Column(name = "Name")
    private String mName;
    
    @OneToOne(fetch=FetchType.LAZY)
    private Customer customer;
    
    @NotNull
    @Column(name = "Balance")
    private double mbalance;
    
   @OneToOne(fetch=FetchType.LAZY)
    private AccountType accountType;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.mId);
        hash = 79 * hash + Objects.hashCode(this.mName);
        hash = 79 * hash + Objects.hashCode(this.customer);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.mbalance) ^ (Double.doubleToLongBits(this.mbalance) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.accountType);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.mId, other.mId)) {
            return false;
        }
        if (!Objects.equals(this.mName, other.mName)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (Double.doubleToLongBits(this.mbalance) != Double.doubleToLongBits(other.mbalance)) {
            return false;
        }
        if (!Objects.equals(this.accountType, other.accountType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "mId=" + mId + ", mName=" + mName + ", customer=" + customer + ", mbalance=" + mbalance + ", accountType=" + accountType + '}';
    }

    public Account() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMbalance() {
        return mbalance;
    }

    public void setMbalance(double mbalance) {
        this.mbalance = mbalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
   
   
}
