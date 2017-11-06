/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.sql.Timestamp;
import java.util.*;


/**
 *
 * @author kevinseveur
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       int numberOfTellers = 5;
       int numberOfMinutes = 60;
       double totalWait = 0;
       int numberOfCustomers = 0;
       Scanner in = new Scanner(System.in);
       boolean repeat = true;
       String usrInput;
       
       
       Teller[] teller = new Teller[numberOfTellers];
       Queue<Customer> line = new LinkedList<Customer>(); 
       
       while (repeat) {
           Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
           long millis1 = timestamp1.getTime();
            for (int i = 0; i < teller.length; i++) {
                teller[i] = new Teller(0);           
            }
            double time = 0;

            while (time <= 120000) {
                Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                long millis2 = timestamp2.getTime();
                time = millis2 - millis1;
                
                if ((time * 1000) == 0) {
                    //Initialize the Customer queue with 5 customers
                    int k = 5;
                    while (k > 0) {
                        Customer newCustomer = new Customer(Bank.randomizer(6));
                        line.add(newCustomer);
                        k--;
                    }
                }
                    
                Customer newCustomer = new Customer(randomizer(6));
                line.add(newCustomer);
                
                for (int i = 0; i < numberOfTellers; i++) {
                        if (!line.isEmpty() && teller[i].isFree()) {
                        Customer frontCustomer = line.peek();
                        numberOfCustomers++;
                        System.out.println("Time: " + (time / 1000));
                        System.out.println("Arrival time: " + frontCustomer.arrival());
                        System.out.println("Total Wait: " + ((time/1000) - frontCustomer.arrival()));
                        System.out.println("-------------------------------------");
                        totalWait += ((time / 1000) - frontCustomer.arrival());
                        teller[i].addCustomer(frontCustomer);
                        line.remove();
                        }    
                }
            }
            System.out.printf("average wait: %.4f ", (totalWait / numberOfCustomers));
            System.out.println("\nTotal running time: " + (time/1000) + " seconds");
              System.out.print("\nWould you like to run the simulator again? "
                      + "Yes or No? ");
              usrInput = in.next();

              usrInput = usrInput.toLowerCase();
              if(usrInput.equals("no")) {
                  repeat = false;
              }

            }
                  }

    private static int randomizer(int time) {  
        int response = 2 + (int)(Math.random() * time + 1);
        return response;
    }
}
