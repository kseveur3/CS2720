package bank;

import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * 1) Program Purpose
 *      This program mimics the operation of a bank with tellers and customers.
 * 2) Solution and Algorithms
 *      My solution involved using a Queue for the Customers, and an Array for
 *      the Tellers. As a teller becomes free, the next customer at the front
 *      of the queue is dequeued and sent to the teller. As tellers become
 *      available, we continue to dequeue customers and send them to tellers for
 *      a time span of 2 minutes.
 * 3) Data Structures
 *      The data structures used were a Queue and an ArrayList.
 * 4) Program description and input/output
 *      This program creates random times for the customer to "enter the bank",
 *      and another random number to signify the time the customer needs to 
 *      spend with the Teller, (processTime). As the Customer goes to see the 
 *      Teller, the process time is added to that Tellers total customer time. 
 * 5) Class Purpose
 *      The Bank class hold the main program. 
 *
 * @author Kevin Seveur
 * Data Structures
 * 11/11/2017
 */
public class Bank {

    static int totalWait = 0;
    static int numberOfCustomers = 0;
    static int numberOfTellers = 5;
    static int time = 0;
    static String usrInput;
    static String loopCheck = "*";

    public static void main(String[] args) throws InterruptedException {

       Scanner in = new Scanner(System.in);
       boolean repeat = true;

       while (repeat) {
           banksim();
           TimeUnit.SECONDS.sleep(130);
           System.out.print("\nWould you like to run the simulator again? "
                      + "Yes or No? ");
           usrInput = in.next();
           usrInput = usrInput.toLowerCase();
           if (usrInput.equals("no")) {
               repeat = false;
           }
       }
    }

    public static void banksim() {

       Teller[] teller = new Teller[numberOfTellers];
       Queue<Customer> line = new LinkedList<Customer>();

        for (int i = 0; i < teller.length; i++) {
               teller[i] = new Teller(0);
           }
        
        //Initialize the Customer queue with 5 customers
        int k = 5;
        while (k > 0) {
            Customer initialCustomer = new Customer(Bank.randomizer(6));
            teller[k - 1].addCustomer(initialCustomer);
            numberOfCustomers++;
            k--;
           }
        System.out.print("Bank Simulator running ");
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Customer newCustomer = new Customer(randomizer(6));
                line.add(newCustomer);
                System.out.print(loopCheck);

                for (int i = 0; i < numberOfTellers; i++) {
                    if (!line.isEmpty() && teller[i].isFree(time)) {
                    Customer frontCustomer = line.peek();
                    numberOfCustomers++;
                    totalWait += (time - frontCustomer.arrival());
                    teller[i].addCustomer(frontCustomer);
                    frontCustomer.initialTellerTime = time;
                    line.remove();
                    }
                }
                if (time == 120) {
                    timer.cancel();
                    System.out.println("\n1) ");
                    System.out.println("  The total amount of customers that"
                            + " visited the bank: " + numberOfCustomers);
                    int idx = 1;
                    System.out.println("2) ");
                    for (Teller x: teller) {
                        System.out.println("  Teller " + idx + " saw "
                                + x.getCustomerCount() + " customers for a total"
                                + " of " + x.timeTotal() + " seconds");
                    idx++;
                    }
                    System.out.println("3) ");
                    System.out.printf(" Average wait: %.4s seconds",
                            (totalWait / numberOfCustomers));
                    System.out.println("\n4) ");
                    System.out.println("  Total number of customers that did"
                            + " not get to see a teller: " + line.size());
                    System.out.println("5) ");
                    System.out.println("  Total running time is: "
                            + time/60 + " minutes");
                    totalWait = 0;
                    numberOfCustomers = 0;
                    time = 0;
                }
                time++;
            }
            }, 0, 1000);
    }

    private static int randomizer(int time) {  
        int response = 2 + (int) (Math.random() * time + 1);
        return response;
    }
}
