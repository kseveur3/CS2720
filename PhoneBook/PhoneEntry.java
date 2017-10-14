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
        setFirst(first);
        setLast(last);
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
        String f = first.toLowerCase();
        Character fi = Character.toUpperCase(f.charAt(0));
        fname = fi + f.substring(1,f.length());
    }

    public void setLast( String last) {
        String l = last.toLowerCase();
        Character lo = Character.toUpperCase(l.charAt(0));
        lname = lo + l.substring(1,l.length());
    }

    /**
     * Precondition -
     * Postcondition -
     */
    public String getPhone() {
        return phone.substring(0,3) + "-" + phone.substring(3,6) + "-" +
                phone.substring(6,phone.length());
    }

    public String getPhoneNoFormat() {
        return phone;
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

}
