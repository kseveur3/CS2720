/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
     * Precondition - None.
     * Postcondition - node created with null values.
     */
     public PhoneEntry() {
        fname = null;
        lname = null;
        phone = null;
    }

    /**
     * Precondition - None.
     * Postcondition - node with values et to input params.
     */
    public PhoneEntry(String first, String last, String phoneNumber) {
        setFirst(first);
        setLast(last);
        phone = phoneNumber;
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Returns the value of full name; first and last.
     */
    public String getName() {
        return fname + " " + lname;
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Returns the value of fist name.
     */
    public String getFirst() {
        return fname;
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Returns the value of last name.
     */    
    public String getLast() {
        return lname;
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Changes or sets the first name value.
     */
    public void setFirst(String first) {
        String f = first.toLowerCase();
        Character fi = Character.toUpperCase(f.charAt(0));
        fname = fi + f.substring(1, f.length());
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Changes or sets the last name value.
     */
    public void setLast( String last) {
        String l = last.toLowerCase();
        Character lo = Character.toUpperCase(l.charAt(0));
        lname = lo + l.substring(1, l.length());
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Retrieves the phone number value.
     */
    public String getPhone() {
        return phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" +
                phone.substring(6, phone.length());
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Retrieves the phone number but doesn't add dashes 
     * to value.
     */
    public String getPhoneNoFormat() {
        return phone;
    }

    /**
     * Precondition - Node already created.
     * Postcondition - Changes or sets the phone value.
     */
    public void setPhone(String newPhone) {
        phone = newPhone;
    }

}

