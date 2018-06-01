/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.account;

import crm.common.DataConverter;
import crm.data.account.Account;
import crm.data.account.Repo_Account;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_Account {

    @Inject
    Repo_Account repo_Account;

    public DmAccount getById(Object Id) {
        DmAccount dmAccount = new DmAccount();
        dmAccount = DataConverter.dataToDomain(repo_Account.read(Id));
        return dmAccount;
    }

    public Boolean save(DmAccount dmAccount) {
        Account account = new Account();
        try {
            account = DataConverter.domainToData(dmAccount);
            repo_Account.create(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveList(List<DmAccount> dmAccounts) {
        try {
            for (int i = 0; i < dmAccounts.size(); i++) {
                repo_Account.create(DataConverter.domainToData(dmAccounts.get(i)));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean edit(DmAccount dmAccount) {
        Account account = new Account();
        try {
            account = DataConverter.domainToData(dmAccount);
            repo_Account.update(account);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<DmAccount> getAll() {
        List<DmAccount> dmAccounts = new ArrayList();
        List<Account> accounts = repo_Account.readAll();
        for (int i = 0; i < accounts.size(); i++) {
            DmAccount dmAccount = new DmAccount();
            dmAccount = DataConverter.dataToDomain(accounts.get(i));
            dmAccounts.add(dmAccount);
        }
        return dmAccounts;
    }

}
