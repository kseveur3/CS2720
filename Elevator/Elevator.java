/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;
import java.util.*;

/**
 *
 * @author kevinseveur
 */
public class Elevator {
    
    final static int numberOfFloors = 12; //number of floorsin building
    final static int numberOfStopsUp = 8; //number of initial stops going up
    final static int numberOfStopsDown = 5; // number of initial stos going down
    static ArrayList<Integer> goingUp = new ArrayList<Integer>();
    static ArrayList<Integer> goingDown = new ArrayList<Integer>();
    static int temp = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arrayValsUp();
        doSort("up");
        System.out.println(Arrays.toString(goingUp.toArray()));
        arrayValsDown();
        doSort("down");
        System.out.println(Arrays.toString(goingDown.toArray()));

        
        
    }
    
    public static void arrayValsUp() {
        for(int idx = 0; idx < numberOfStopsUp; idx++) {
            temp =  1 + (int)(Math.random() * numberOfFloors);
            if (goingUp.contains(temp)) {
                idx--;
            } else {
                goingUp.add(temp);
            } 
    }  
}
    
    public static void arrayValsDown() {
        for(int idx = numberOfStopsDown - 1; idx >= 0; idx--) {
            temp =  1 + (int)(Math.random() * goingUp.get(numberOfStopsUp-1));
            if (goingDown.contains(temp)) {
                idx++;
            } else {
                goingDown.add(temp);
            }        
        }
    }
    
    public static void doSort(String direction) {
        int min;
        int max;

        if (direction.equals("up")) {
            for (int idx = 0; idx < goingUp.size()-1; idx++) {
                min = idx;
                for (int jdx = idx + 1; jdx < goingUp.size(); jdx++) {
                    if (goingUp.get(jdx) < goingUp.get(idx)) {
                        min = jdx;
                        swap(goingUp, idx, min);
                    }
                }
            }
        } else {
           for (int idx = 0; idx < goingDown.size()-1; idx++) {
               max = idx;
                for (int jdx = idx + 1; jdx < goingDown.size(); jdx++) {
                    if (goingDown.get(jdx) > goingDown.get(idx)) {
                        max = jdx;
                        swap(goingDown, idx, max);
                    }
                } 
            }
        }
    }
    
    public static void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
        
    }
    

//class elevatorClass {
   
    //movement method, noStop(current floor, next floor)
        //if current floor < next floor
            //print "Going up: Now at floor {current} "
    
        //if current floor > next floor
            //print "Going down: Now at floor {next}"
        //2 seconds countdown
    
    
    //Movement method, nextStop(starting floor, next floor)
        //if start is less than next
            //print "Going up: Now at floor {start} and stopping at floor {next}
    
        //if start is more than start
            //print "Going down: Now at floor {next} and stopping at floor {start}
        //3 seconds countdown on screen
     
    
    // Countdown method timer(int seconds, String p) throws InterruptedException{
        //if p == print
            //print countdows to screen
        //else 
            //don't print countdown to screen
    
    /*static Thread thread = new Thread();
    for(int c = 3; c>= 0; c--) {
    thread.sleep(1000);
    System.out.print("c ");
 
        
    Thread thread = new Thread();
    for(int c = 3; c>= 0; c--) {
    thread.sleep(1000);
    if(c>0) {
    System.out.print(c + " "); */
        
          
}


