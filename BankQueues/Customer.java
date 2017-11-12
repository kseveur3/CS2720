package bank;
import java.lang.*;

 /**
 *1) Class Purpose
 *      The Customer class hold the Customer object for use by the Bank
 *      main program.
 */
public class Customer {

    protected int arrivalTime;
    protected int processTime;
    public int initialTellerTime;

    /**
     * Precondition - 
     * Postcondition - 
     */
    public Customer(int at) {
        arrivalTime = at;
        processTime = 2 + (int) (Math.random() * 6);
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public Customer() {
        arrivalTime = 0;
        processTime = 0;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public boolean done() {
        return --processTime < 0;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public int arrival() {
        return arrivalTime;
    }
    
    /**
     * Precondition - 
     * Postcondition - 
     */
    public int getProcessTime() {
        return processTime;
    }
}
