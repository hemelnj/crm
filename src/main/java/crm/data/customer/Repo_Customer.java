/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.data.customer;

import crm.common.Repo_CRM;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Repo_Customer extends Repo_CRM<Customer> {

    public Repo_Customer() {
        super(Customer.class);
    }
    
      public List<Customer> getAllCustomerByState(String state)throws ParseException {
        List<Customer> getAllCustomerByState = null;
        try {
            getAllCustomerByState = getEntityManager()
                    .createNamedQuery("customer.getAllCustomerByState")
                    .setParameter("state", state)
                    .getResultList();
        } catch (Exception exp) {
            throw exp;
        }
        return getAllCustomerByState;
    }
}
