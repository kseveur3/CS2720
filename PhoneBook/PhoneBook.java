/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedir;

import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author kevinseveur
 */
public class phonedir {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usrInput1;
        String usrInput2;
        String first;
        String last;
        String phone;
        boolean allRepeat = true;
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        String enteredFirst;
        String enteredLast;
        String enteredPhone;
        int currentRecord = -1;
        LinkedList<PhoneEntry> list = new LinkedList<PhoneEntry>();

            while (allRepeat) {

            System.out.println("\nPlease make your selection: \n\n"
                    + "a) Show all records\n"
                    + "d) Delete the current record\n"
                    + "f) Change the first name in the current record\n"
                    + "l) Change the last name in the current record\n"
                    + "n) Add a new record\n"
                    + "p) Change the phone number in the current record\n"
                    + "s) Select a record from the record list to become the"
                    + " current record\n"
                    + "q) Quit\n");
            usrInput1 = in.next();
            
            switch(usrInput1) {
                case "a": 
                    for (PhoneEntry p: list) {
                    System.out.printf("Name : %-20s PhoneNo :%1s\n\n",
                            p.getName(), p.getPhone());
                    }
                    break;
                
                case "d": 
                    if (currentRecord != -1) {
                        list.remove(currentRecord);
                    } else {
                        System.out.println("You must set a current record "
                                + "first!");
                    }
                    break;
                    
                case "f": 
                    if (currentRecord != -1) {
                        System.out.print("Enter new first name: ");
                        first = in.next();
                        PhoneEntry f = new PhoneEntry();
                        f = list.get(currentRecord);
                        f.setFirst(first);
                    } else {
                        System.out.println("You must set a current record "
                                + "first!");
                    }
                    break;
                    
                case "l": 
                    if (currentRecord != -1) {
                        System.out.print("Enter new last name: ");
                        last = in.next();
                        PhoneEntry l = new PhoneEntry();
                        l = list.get(currentRecord);
                        l.setLast(last);
                    } else {
                        System.out.println("You must set a current record "
                                + "first!");
                    }
                    break;
                    
                case "n": 
                    System.out.println("Enter first name: ");
                    first = in.next();
                    System.out.println("Enter last name: ");
                    last = in.next();
                    System.out.println("Enter phone number: ");
                    phone = in.next();
                    if (phone.length() > 10) {
                        System.out.println("You have entered an invalid format"
                                + "phone number. Please use the format"
                                + " ##########");
                    } else {
                    PhoneEntry n = new PhoneEntry(first, last, phone);
                    list.add(n);
                    currentRecord = list.indexOf(n);
                    System.out.println("Current Record Location: " 
                            +currentRecord);
                    }
                    break;
                    
                case "p": 
                    System.out.print("Enter new phone number: ");
                    phone = in.next();
                    PhoneEntry p = new PhoneEntry();
                    p = list.get(currentRecord);
                    p.setPhone(phone);
                    break;
                    
                case "s": 
                    System.out.println("Enter first name: ");
                    first = in.next();
                    System.out.println("Enter last name: ");
                    last = in.next();
                    PhoneEntry s = new PhoneEntry();
                    s.setFirst(first);
                    s.setLast(last);
                    int idx = -1;
                    for (PhoneEntry px : list) {
                        idx++;
                        if(px.getFirst().equals(first) && px.getLast().
                                equals(last)) {
                            currentRecord = idx;
                        } else {
                            System.out.println("No matching record found.");
                        }
                    }

                    System.out.println("Current Record Location: " 
                            +currentRecord);
                    break;
                    
                case "q": allRepeat = false; break;
                
                default : System.out.println("Illegal command!");
                
                    
            }

            /*while (repeat) {
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
            }*/
        }
        in.close();
     
    }
    
    public void displayList(LinkedList<PhoneEntry> l) {
        int idx = 0;
        int max = 1;
        
        for (idx = 0; idx < l.size(); idx++) {
           if ((l.get(idx).getLast()).compareTo(l.get(max).getLast()) == 1) {
               
            
        }
            
            
        }
    }
    
}
