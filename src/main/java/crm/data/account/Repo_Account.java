/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.account;

import crm.common.Repo_CRM;

/**
 *
 * @author Admin
 */
public class Repo_Account extends Repo_CRM<Account> {

    public Repo_Account() {
        super(Account.class);
    }
}
