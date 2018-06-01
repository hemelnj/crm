/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.accounttype;

import crm.common.DataConverter;
import crm.data.accounttype.AccountType;
import crm.data.accounttype.Repo_AccountType;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_AccountType {

    @Inject
    Repo_AccountType repo_AccountType;

    public DmAccountType getById(Object Id) {
        DmAccountType dmAccountType = new DmAccountType();
        dmAccountType = DataConverter.dataToDomain(repo_AccountType.read(Id));
        return dmAccountType;
    }

    public Boolean save(DmAccountType dmAccountType) {
        AccountType accountType = new AccountType();
        try {
            accountType = DataConverter.domainToData(dmAccountType);
            repo_AccountType.create(accountType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveList(List<DmAccountType> dmAccountType) {
        try {
            for (int i = 0; i < dmAccountType.size(); i++) {
                repo_AccountType.create(DataConverter.domainToData(dmAccountType.get(i)));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean edit(DmAccountType dmAccountType) {
        AccountType accountType = new AccountType();
        try {
            accountType = DataConverter.domainToData(dmAccountType);
            repo_AccountType.update(accountType);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<DmAccountType> getAll() {
        List<DmAccountType> dmAccountTypes = new ArrayList();
        List<AccountType> accountTypes = repo_AccountType.readAll();
        for (int i = 0; i < accountTypes.size(); i++) {
            DmAccountType dmAccountType = new DmAccountType();
            dmAccountType = DataConverter.dataToDomain(accountTypes.get(i));
            dmAccountTypes.add(dmAccountType);
        }
        return dmAccountTypes;
    }

}
