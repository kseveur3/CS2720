/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

/**
 *
 * @author kevinseveur
 */
public class PhoneEntry implements Comparable<PhoneEntry> {

    private String name;
    private String phone;
    
    /**
     * Precondition - 
     * Postcondition - 
     */
    public PhoneEntry() {
        name = null;
        phone = null;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public PhoneEntry(String name2, String phoneNumber) {
        name = name2;
        phone = phoneNumber;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public String getName() {
        return name;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public void setName( String newName) {
        name = newName;
    }

    /**
     * Precondition - 
     * Postcondition - 
     */
    public String getPhone() {
        return phone.substring(0,0) + "(" + phone.substring(0,3) + ")" +
                phone.substring(3,phone.length());
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
    public void display() {
        System.out.println("Name : " + name + " PhoneNo : " + phone);
    }
    
    
    @Override
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
        }
}
