/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.customer;

import crm.common.DataConverter;
import crm.data.customer.Customer;
import crm.data.customer.Repo_Customer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_Customer {

    @Inject
    Repo_Customer repo_Customer;

    public DmCustomer getById(Object Id) {
        DmCustomer dmCustomer = new DmCustomer();
        dmCustomer = DataConverter.dataToDomain(repo_Customer.read(Id));
        return dmCustomer;
    }

    public Boolean save(DmCustomer dmCustomer) {
        Customer customer = new Customer();
        try {
            customer = DataConverter.domainToData(dmCustomer);
            repo_Customer.create(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveList(List<DmCustomer> dmCustomers) {
        try {
            for (int i = 0; i < dmCustomers.size(); i++) {
                repo_Customer.create(DataConverter.domainToData(dmCustomers.get(i)));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean edit(DmCustomer dmCustomer) {
        Customer customer = new Customer();
        try {
            customer = DataConverter.domainToData(dmCustomer);
            repo_Customer.update(customer);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean editList(List<DmCustomer> dmCustomers) {
        try {
            for (int i = 0; i < dmCustomers.size(); i++) {
                edit(dmCustomers.get(i));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<DmCustomer> getAll() {
        List<DmCustomer> dmCustomers = new ArrayList();
        List<Customer> customers = repo_Customer.readAll();
        for (int i = 0; i < customers.size(); i++) {
            DmCustomer dmCustomer = new DmCustomer();
            dmCustomer = DataConverter.dataToDomain(customers.get(i));
            dmCustomers.add(dmCustomer);
        }
        return dmCustomers;
    }

    public List<DmCustomer> getAllByState(String state) throws ParseException {
        List<DmCustomer> dmCustomers = new ArrayList();
        List<Customer> customers = repo_Customer.getAllCustomerByState(state);
        for (int i = 0; i < customers.size(); i++) {
            DmCustomer dmCustomer = new DmCustomer();
            dmCustomer = DataConverter.dataToDomain(customers.get(i));
            dmCustomers.add(dmCustomer);
        }
        return dmCustomers;
    }

}
