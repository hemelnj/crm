/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.transactionledger;

import crm.business.customer.DmCustomer;
import crm.common.DataConverter;
import crm.data.customer.Customer;
import crm.data.transactionledger.Repo_TransactionLedger;
import crm.data.transactionledger.TransactionLedger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_Transactionledger {

    @Inject
    Repo_TransactionLedger repo_TransactionLedger;

    public DmTransactionLedger getById(Object Id) {
        DmTransactionLedger dmTransactionLedger = new DmTransactionLedger();
        dmTransactionLedger = DataConverter.dataToDomain(repo_TransactionLedger.read(Id));
        return dmTransactionLedger;
    }

    public Boolean save(DmTransactionLedger dmTransactionLedger) {
        TransactionLedger transactionLedger = new TransactionLedger();
        try {
            transactionLedger = DataConverter.domainToData(dmTransactionLedger);
            repo_TransactionLedger.create(transactionLedger);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveList(List<DmTransactionLedger> dmTransactionLedgers) {
        try {
            for (int i = 0; i < dmTransactionLedgers.size(); i++) {
                repo_TransactionLedger.create(DataConverter.domainToData(dmTransactionLedgers.get(i)));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean edit(DmTransactionLedger dmTransactionLedger) {
        TransactionLedger transactionLedger = new TransactionLedger();
        try {
            transactionLedger = DataConverter.domainToData(dmTransactionLedger);
            repo_TransactionLedger.update(transactionLedger);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<DmTransactionLedger> getAll() {
        List<DmTransactionLedger> dmTransactionLedgers = new ArrayList();
        List<TransactionLedger> transactionLedgers = repo_TransactionLedger.readAll();
        for (int i = 0; i < transactionLedgers.size(); i++) {
            DmTransactionLedger dmTransactionLedger = new DmTransactionLedger();
            dmTransactionLedger = DataConverter.dataToDomain(transactionLedgers.get(i));
            dmTransactionLedgers.add(dmTransactionLedger);
        }
        return dmTransactionLedgers;
    }

}
