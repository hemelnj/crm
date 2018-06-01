/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.account;

import crm.business.accounttype.DmAccountType;
import crm.business.customer.DmCustomer;

/**
 *
 * @author Admin
 */
public class DmAccount {

    private Long mId;
    private String mName;
    private DmCustomer customer;
    private double mbalance;
    private DmAccountType accountType;

    public DmAccount() {
    }

    @Override
    public String toString() {
        return "DmAccount{" + "mId=" + mId + ", mName=" + mName + ", customer=" + customer + ", mbalance=" + mbalance + ", accountType=" + accountType + '}';
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

    public DmCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DmCustomer customer) {
        this.customer = customer;
    }

    public double getMbalance() {
        return mbalance;
    }

    public void setMbalance(double mbalance) {
        this.mbalance = mbalance;
    }

    public DmAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(DmAccountType accountType) {
        this.accountType = accountType;
    }

    public DmAccount(Long mId, String mName, DmCustomer customer, double mbalance, DmAccountType accountType) {
        this.mId = mId;
        this.mName = mName;
        this.customer = customer;
        this.mbalance = mbalance;
        this.accountType = accountType;
    }

    
}
