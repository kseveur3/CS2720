/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elevator;

import java.util.ArrayList;

/**
 *
 * @author kevinseveur
 */
public class elevator {

    final int numberOfFloors = 12; //number of floorsin building
    final int numberOfStopsUp = 8; //number of initial stops going up
    final int numberOfStopsDown = 5; // number of initial stos going down
    ArrayList<Integer> goingUp = new ArrayList<Integer>();
    ArrayList<Integer> goingDown = new ArrayList<Integer>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
    Thread thread = new Thread();
    for(int c = 3; c>= 0; c--) {
    thread.sleep(1000);
    if(c>0) {
    System.out.print(c + " ");
        // TODO code application logic here
    }
    }
    
}
}
