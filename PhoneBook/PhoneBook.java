/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author kevinseveur
 */
public class PhoneBook {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int usrInput1 = 0;
        String usrInput2;
        boolean allRepeat = true;
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        String enteredFirst;
        String enteredLast;
        String enteredPhone;
        LinkedList<PhoneEntry> list = new LinkedList<PhoneEntry>();

            while (allRepeat) {

            System.out.println("\nPlease make your selection: \n\n"
                    + "1) Add a new phone book entry\n"
                    + "2) Edit an existing name entry\n"
                    + "3) Edit an existing number entry\n"
                    + "4) Remove an existing entry\n"
                    + "5) Print all contacts");

            while (repeat) {
                while (!in.hasNextInt()) {
                    System.out.println("Please enter a value between 1 and 4: ");
                    in.next();
                }
                repeat = false;
                usrInput1 = in.nextInt();

                if (usrInput1 > 5 || usrInput1 < 1) {
                    System.out.println("Please enter a value between 1 and 4: ");
                    repeat = true;
                    }
            }
            if (usrInput1 == 1) {
                System.out.println("Please add the contacts full name: ");
                enteredFirst = in.next();
                enteredLast = in.next();
                System.out.println("Please add the contacts phone number "
                        + "without dashes: ");
                while (!in.hasNextInt()) {
                    System.out.println("Please enter numbers only: ");
                    in.next();
                }
                enteredPhone = in.next();
                list.add(new PhoneEntry(enteredFirst + " " + enteredLast
                        , enteredPhone)); 
                Collections.sort(list);

            } else if (usrInput1 == 2) {

            } else if (usrInput1 == 3) {

            } else if (usrInput1 == 4) {
                
            } else {
                for (PhoneEntry p: list) {
                    System.out.printf("Name : %-20s PhoneNo :%1s\n\n",p.getName(),
                            p.getPhone());
                }

            }
            
            System.out.println("Would you like to repeat the program"
                    + " (yes or no)?");
            usrInput2 = in.next();

            while (!usrInput2.equals("yes") && !usrInput2.equals("no")) {
                System.out.println("Please enter \"yes\" or \"no\"");
                usrInput2 = in.next();
            }
            if (usrInput2.equals("yes")) {
                allRepeat = true;
                repeat = true;
            } else {
                allRepeat = false;
            }
        }
        in.close();
     
    }
    
}
