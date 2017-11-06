/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;
import java.lang.*;

/**
 *
 * @author kevinseveur
 */
public class Customer {
    
    protected int arrivalTime;
    protected int processTime;
    
    public Customer(int at) {
        arrivalTime = at;
        processTime = 2 + (int)(Math.random() * 6);
    }
    
    public Customer() {
        arrivalTime = 0;
        processTime = 0;       
    }
    
    public boolean done() {
        return --processTime < 0;
    }
    
    public int arrival() {
        return arrivalTime;
    }
    
}
