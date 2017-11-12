package bank;

/**
 *1) Class Purpose
 *   The Teller class hold the Teller object for use by the Bank main program.
 */
public class Teller {
    protected boolean free; 
    protected Customer customer;
    protected int customerCount = 0;
    protected int customerTime = 0;

    /**
     * Precondition - 
     * Postcondition - 
     */
    public Teller() {
        free = true;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public Teller(int time) {
        Customer cust = new Customer(time);
        customerTime = cust.getProcessTime();
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public boolean isFree(int currentClock) {
        if (free) {
            return true;
        } else if (currentClock >= (customer.initialTellerTime
                + customer.getProcessTime())) {
            free = true;
        }
        return free;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public void addCustomer(Customer c) {
        customer = c;
        free = false;
        customerCount++;
        customerTime += c.getProcessTime();
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public int timeTotal() {
        return customerTime;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public int getCustomerCount() {
        return customerCount;
    }
}
