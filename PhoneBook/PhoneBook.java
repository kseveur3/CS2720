/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

            switch (usrInput1) {
                case "a":
                    printList(list);
                    break;

                case "d":
                    if (currentRecord != -1) {
                        list.remove(currentRecord);
                    } else {
                        System.out.println("You must set a current record "
                                + "first!");
                    }                    break;

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
                        System.out.println("Location: " + loc);
                        if (loc == -1) {
                            System.out.println("ERROR: The specified phone number is already in the phone directory!");
                            break;
                        }
                        list.add(loc, n);
                        currentRecord = list.indexOf(n);
                        //System.out.println("Current Record Location: "
                        //        + currentRecord);
                    }
                    break;

                case "p":
                    System.out.print("Enter new phone number: ");
                    phone = in.next();
                    int phoneTest2 = phoneNumberCheck(list, phone);
                    if (phoneTest2 == -1) {
                        break;
                    }
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
                        if (px.getFirst().equals(first) && px.getLast().
                                equals(last)) {
                            currentRecord = idx;
                        }
                    }
                    if (idx == -1) {
                        System.out.println("No matching record found.");
                    }
                    //System.out.println("Current Record Location: "
                    //        + currentRecord);
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

    public static int locationFind(LinkedList<PhoneEntry> l, PhoneEntry p) {
        if (l.size() == 0) {
            return 0;
        } else {

            for (int idx = 0; idx < l.size(); idx++) {
                if (l.get(idx) == null) {
                    return idx--;
                } else if ((p.getLast()).compareTo(l.get(idx).getLast()) == 0) {
                    if ((p.getFirst()).compareTo(l.get(idx).getFirst()) == 0) {
                        if ((p.getPhone()).compareTo(l.get(idx).getPhone()) == 0) {
                            return -1;
                        } else if ((p.getPhone()).compareTo(l.get(idx).getPhone()) > 0) {
                            continue;

                        } else {
                            return idx--;
                        }

                    } else if ((p.getFirst()).compareTo(l.get(idx).getFirst()) > 0) {
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

    public static int phoneNumberCheck(LinkedList<PhoneEntry> l, String p) {
        int flag = 1;
        for (PhoneEntry temp: l) {
            if (p.compareTo(temp.getPhoneNoFormat()) == 0) {
                System.out.println("The phone number entered is already in the direcory");
                flag = -1;
            }
        }
        return flag;
    }

    public static void printList(LinkedList<PhoneEntry> li) {
        for (PhoneEntry p : li) {
            System.out.printf("Name : %-20s PhoneNo :%1s\n\n",
                    p.getName(), p.getPhone());
        }
    }
}
