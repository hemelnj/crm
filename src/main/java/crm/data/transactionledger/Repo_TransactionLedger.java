/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.transactionledger;

import crm.common.Repo_CRM;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Repo_TransactionLedger extends Repo_CRM<TransactionLedger> {

    public Repo_TransactionLedger() {
        super(TransactionLedger.class);
    }
}
