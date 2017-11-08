/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author kevinseveur
 */
public class Teller {
    protected boolean free;
    protected Customer customer;
    protected int customerCount = 0;
    protected int customerTime = 0;
    
    
    public Teller() {
        free = true;
    }
    
    public Teller(int time) {
        Customer cust = new Customer(time);
        addCustomer(cust, cust.getProcessTime());
    }
    
    
    public boolean isFree() {
        if (free) {
            return true;
        }
        if (customer.done()) {
            free = true;
        }
        return free;
    }
    
    public void addCustomer(Customer c, int t) {
        customer = c;
        free = false;
        customerCount += 1;
        customerTime += t;
        
        
    }  
    
    public int timeTotal() {
    	return customerTime;
    }

    public int getCustomerCount() {
    	return customerCount;
    }
}
