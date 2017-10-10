/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.LinkedList;

/**
 *
 * @author kevinseveur
 */
public class PhoneEntry {

    private String fname;
    private String lname;
    private String phone;
    private int entry;
    
    /**
     * Precondition - 
     * Postcondition - 
     */
    public PhoneEntry() {
        fname = null;
        lname = null;
        phone = null;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public PhoneEntry(String first, String last, String phoneNumber) {
        fname = first;
        lname = last;
        phone = phoneNumber;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public String getName() {
        return fname + " " + lname;
    }
    
    public String getFirst() {
        return fname;
    }
    
    public String getLast() {
        return lname;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public void setFirst(String first) {
        fname = first;  
    }
    
    public void setLast( String last) {
        lname = last;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public String getPhone() {
        return phone.substring(0,3) + "-" + phone.substring(3,6) + "-" +
                phone.substring(6,phone.length());
    }
    
    public int getElement(LinkedList<PhoneEntry> list, String first, String last) {
       int idx = -1;
       
        for (PhoneEntry p : list) {
            idx++;
            if(p.fname.equals(first) && p.lname.equals(last)) {
                return idx;
            } 
        }
        return -1;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public void setPhone(String newPhone) {
        phone = newPhone;
    }
    
    /**
     * Precondition - 
     * Postcondition - 
     */
    public void display(LinkedList<PhoneEntry> list) {
        for (PhoneEntry p: list) {
                    System.out.printf("Name : %-20s PhoneNo :%1s\n\n",
                            p.getName(), p.getPhone());
        } 
    }

    
    
    /*@Override
	public int compareTo(PhoneEntry o) {
            if (this.name.compareTo(o.name) != 0) {
                return this.name.compareTo(o.name);
            }
            int comparedPhone = Integer.parseInt(o.phone);
            int currentPhone = Integer.parseInt(this.phone);
		if (currentPhone > comparedPhone) {
			return 1;
		} else if (currentPhone == comparedPhone) {
			return 0;
		} else {
			return -1;
		}
        }*/
}
