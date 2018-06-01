/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.common;

import crm.business.account.DmAccount;
import crm.business.accounttype.DmAccountType;
import crm.business.customer.DmCustomer;
import crm.business.transactionledger.DmTransactionLedger;
import crm.data.account.Account;
import crm.data.accounttype.AccountType;
import crm.data.customer.Customer;
import crm.data.transactionledger.TransactionLedger;

/**
 *
 * @author Admin
 */
public class DataConverter {

    public static DmCustomer dataToDomain(Customer customer) {
        DmCustomer dmCustomer = new DmCustomer();
        dmCustomer.setmAddress(customer.getmAddress());
        dmCustomer.setmAge(customer.getmAge());
        dmCustomer.setmDob(customer.getmDob());
        dmCustomer.setmFathersName(customer.getmFathersName());
        dmCustomer.setmId(customer.getmId());
        dmCustomer.setmMaritialStatus(customer.getmMaritialStatus());
        dmCustomer.setmName(customer.getmName());
        dmCustomer.setmNid(customer.getmNid());
        dmCustomer.setmState(customer.getmState());
        return dmCustomer;
    }

    public static DmTransactionLedger dataToDomain(TransactionLedger transactionLedger) {
        DmTransactionLedger dmTransactionLedger = new DmTransactionLedger();
        dmTransactionLedger.setAccount(dataToDomain(transactionLedger.getAccount()));
        dmTransactionLedger.setmId(transactionLedger.getmId());
        dmTransactionLedger.setmPostBalance(transactionLedger.getmPostBalance());
        dmTransactionLedger.setmPreBalance(transactionLedger.getmPreBalance());
        dmTransactionLedger.setmTimestamp(transactionLedger.getmTimestamp());
        return dmTransactionLedger;
    }

    public static DmAccount dataToDomain(Account account) {
        DmAccount dmAccount = new DmAccount();
        dmAccount.setmId(account.getmId());
        dmAccount.setAccountType(dataToDomain(account.getAccountType()));
        dmAccount.setCustomer(dataToDomain(account.getCustomer()));
        dmAccount.setMbalance(account.getMbalance());
        dmAccount.setmName(account.getmName());
        return dmAccount;
    }

    public static DmAccountType dataToDomain(AccountType accountType) {
        DmAccountType dmAccountType = new DmAccountType();
        dmAccountType.setmId(accountType.getmId());
        dmAccountType.setmName(accountType.getmName());
        return dmAccountType;
    }

    public static Customer domainToData(DmCustomer dmCustomer) {
        Customer customer = new Customer();
        customer.setmAddress(dmCustomer.getmAddress());
        customer.setmAge(dmCustomer.getmAge());
        customer.setmDob(dmCustomer.getmDob());
        customer.setmFathersName(dmCustomer.getmFathersName());
        customer.setmId(dmCustomer.getmId());
        customer.setmMaritialStatus(dmCustomer.getmMaritialStatus());
        customer.setmName(dmCustomer.getmName());
        customer.setmNid(dmCustomer.getmNid());
         customer.setmState(dmCustomer.getmState());
        return customer;
    }

    public static TransactionLedger domainToData(DmTransactionLedger dmTransactionLedger) {
        TransactionLedger transactionLedger = new TransactionLedger();
        transactionLedger.setAccount(domainToData(dmTransactionLedger.getAccount()));
        transactionLedger.setmId(dmTransactionLedger.getmId());
        transactionLedger.setmPostBalance(dmTransactionLedger.getmPostBalance());
        transactionLedger.setmPreBalance(dmTransactionLedger.getmPreBalance());
        transactionLedger.setmTimestamp(dmTransactionLedger.getmTimestamp());
        return transactionLedger;
    }

    public static Account domainToData(DmAccount dmAccount) {
        Account account = new Account();
        account.setAccountType(domainToData(dmAccount.getAccountType()));
        account.setCustomer(domainToData(dmAccount.getCustomer()));
        account.setMbalance(dmAccount.getMbalance());
        account.setmId(dmAccount.getmId());
        account.setmName(dmAccount.getmName());
        return account;
    }

    public static AccountType domainToData(DmAccountType dmAccountType) {
        AccountType accountType = new AccountType();
        accountType.setmId(dmAccountType.getmId());
        accountType.setmName(dmAccountType.getmName());
        return accountType;
    }

}
