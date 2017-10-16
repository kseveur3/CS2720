
package phonedir;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1) Program Purpose
 *      This program allows is a phone directory that allows a user to 
 *      enter names and phone numbers into directory.
 * 2) Solution and Algorithms
 *      My solution involved utilizing the Java library for the LinkedList 
 *      data structure. I also created an algorithm to manage placement of new
 *      phone book nodes into the LinkedLists.
 * 3) Data Structures
 *      The only data structure used was a LimkedList.
 * 4) Program description and input/output
 *      This program is a phone book that stores names and phone numbers for 
 *      contacts. It will store the phone book entries alphabetically 
 *      based on last name, then first name, then phone number. It will 
 *      only allow unique phone numbers into the list.
 * 5) Class Purpose
 *      This class is the main program for the phone directory program.
 *
 * @author kevin Seveur
 * 10/15/2017
 */
public class phonedir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String usrInput1;
        String first;
        String last;
        String phone;
        boolean allRepeat = true;
        Scanner in = new Scanner(System.in);
        int currentRecord = -1;
        LinkedList<PhoneEntry> list = new LinkedList<PhoneEntry>();

        while (allRepeat) {

            System.out.println("\n\n"
                    + "a) Show all records\n"
                    + "d) Delete the current record\n"
                    + "f) Change the first name in the current record\n"
                    + "l) Change the last name in the current record\n"
                    + "n) Add a new record\n"
                    + "p) Change the phone number in the current record\n"
                    + "s) Select a record from the record list to become the"
                    + " current record\n"
                    + "q) Quit\n\n"
                    + "Please make your selection: ");
            usrInput1 = in.next();

            switch (usrInput1) {
                case "a":
                    if (list.isEmpty()) {
                    System.out.println("\nNo current record");
                    break;
                    }
                    printList(list);
                    break;

                case "d":
                    if (currentRecord != -1) {
                        String removedName = list.get(currentRecord).getName();
                        list.remove(currentRecord);
                        System.out.print("The record for " + removedName
                                + " has been deleted!");
                    } else {
                        System.out.println("\nYou must set a current record "
                                + "first!");
                    }

                    currentRecord = 0;
                    System.out.printf("\nCurrent record is now: %-5s %1s ",
                    list.get(currentRecord).getName(), list.get(currentRecord)
                            .getPhone());
                    
                    break;

                case "f":
                    if (list.isEmpty()) {
                        System.out.println("\nNo current record");
                        break;
                    }
                    if (currentRecord != -1) {
                        System.out.print("Enter new first name: ");
                        first = in.next();
                        PhoneEntry f = new PhoneEntry();
                        f = list.get(currentRecord);
                        f.setFirst(first);
                    } else {
                        System.out.println("\nYou must set a current record "
                                + "first!");
                    }
                    System.out.printf("\nCurrent record is: %-5s %1s ",
                    list.get(currentRecord).getName(), list.get(currentRecord)
                            .getPhone());
                    break;

                case "l":
                    if (list.isEmpty()) {
                        System.out.println("\nNo current record");
                        break;
                    }
                    if (currentRecord != -1) {
                        System.out.print("Enter new last name: ");
                        last = in.next();
                        PhoneEntry l = new PhoneEntry();
                        l = list.get(currentRecord);
                        l.setLast(last);
                    } else {
                        System.out.println("\nYou must set a current record "
                                + "first!");
                    }
                    System.out.printf("\nCurrent record is: %-5s %1s ",
                    list.get(currentRecord).getName(), list.get(currentRecord)
                            .getPhone());
                    break;

                case "n":
                    System.out.println("Enter first name: ");
                    first = in.next();
                    System.out.println("Enter last name: ");
                    last = in.next();
                    System.out.println("Enter phone number: ");
                    phone = in.next();
                    int phoneTest = phoneNumberCheck(list, phone);
                    if (phoneTest == -1) {
                        break;
                    }
                    if (phone.length() > 10) {
                        System.out.println("You have entered an invalid format"
                                + "phone number. Please use the format"
                                + " ##########");
                    } else {
                        PhoneEntry n = new PhoneEntry(first, last, phone);
                        int loc = locationFind(list, n);
                        if (loc == -1) {
                            System.out.println("ERROR: The specified phone "
                                    + "number is already in the phone directory!");
                            break;
                        }
                        list.add(loc, n);
                        currentRecord = list.indexOf(n);
                        System.out.printf("\nCurrent record is: %-5s %1s ",
                        list.get(currentRecord).getName(),
                        list.get(currentRecord)
                            .getPhone());
                    }
                    break;

                case "p":
                    if (list.isEmpty()) {
                        System.out.println("\nNo current record");
                        break;
                    }
                    System.out.print("Enter new phone number: ");
                    phone = in.next();
                    int phoneTest2 = phoneNumberCheck(list, phone);
                    if (phoneTest2 == -1) {
                        break;
                    }
                    PhoneEntry p = new PhoneEntry();
                    p = list.get(currentRecord);
                    p.setPhone(phone);
                    System.out.printf("\nCurrent record is: %-5s %1s ",
                    list.get(currentRecord).getName(), list.get(currentRecord)
                            .getPhone());
                    break;

                case "s":
                    if (list.isEmpty()) {
                    System.out.println("\nNo current record");
                    break;
                    }
                    System.out.println("Current List: ");
                    printList(list);
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
                        if (px.getFirst().equals(s.getFirst()) && px.getLast().
                                equals(s.getLast())) {
                            currentRecord = idx;
                        }
                    }
                    if (idx == -1) {
                        System.out.println("No matching record found.");
                    }
                    System.out.printf("\nCurrent record is: %-5s %1s ",
                    list.get(currentRecord).getName(), list.get(currentRecord)
                            .getPhone());
                    break;

                case "q":
                    allRepeat = false;
                    break;

                default:
                    System.out.println("Illegal command!");


            }
        }
        in.close();

    }

    /**
     * Precondition - Linked List is created.
     * Postcondition - Returns the index location where new node should
     * be insert.
     */
    public static int locationFind(LinkedList<PhoneEntry> l, PhoneEntry p) {
        if (l.isEmpty()) {
            return 0;
        } else {

            for (int idx = 0; idx < l.size(); idx++) {
                if (l.get(idx) == null) {
                    return idx--;
                } else if ((p.getLast()).compareTo(l.get(idx).getLast()) == 0) {
                    if ((p.getFirst()).compareTo(l.get(idx).getFirst()) == 0) {
                        if ((p.getPhone()).compareTo(l.get(idx).getPhone())
                                == 0) {
                            return -1;
                        } else if ((p.getPhone()).compareTo
                            (l.get(idx).getPhone()) > 0) {
                            continue;

                        } else {
                            return idx--;
                        }

                    } else if ((p.getFirst()).compareTo
                        (l.get(idx).getFirst()) > 0) {
                        continue;

                    } else {
                        return idx--;
                    }
                } else if ((p.getLast()).compareTo(l.get(idx).getLast()) > 0) {
                    continue;
                } else {
                    return idx--;
                }
            }
        }
        return l.size();
    }

    /**
     * Precondition - None.
     * Postcondition - Returns a value that represents whether the phone 
     * number exists in the current list or not. -1 is returned if the number
     * is in the list, 1 if the number is unique.
     */
    public static int phoneNumberCheck(LinkedList<PhoneEntry> l, String p) {
        int flag = 1;
        for (PhoneEntry temp: l) {
            if (p.compareTo(temp.getPhoneNoFormat()) == 0) {
                System.out.println("The phone number entered is"
                        + " already in the direcory");
                flag = -1;
            }
        }
        return flag;
    }

    /**
     * Precondition - None.
     * Postcondition - Prints the current phone directory to the console.
     */
    public static void printList(LinkedList<PhoneEntry> li) {
        System.out.println("Name            PhoneNo");
        System.out.println("---------       ----------");
        for (PhoneEntry p : li) {
            System.out.printf("%-15s %1s\n",
                    p.getName(), p.getPhone());
        }
    }
}
