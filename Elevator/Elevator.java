/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * 1) Program Purpose
 *      This program mimics the operation of an elevator with preset floor stop
 *      requests.
 * 2) Solution and Algorithms
 *      My solution involved breaking the tasks down to very individualized
 *      methods. The main function primarily holds the method calls.
 *      I used a solution sort algorithm to order the floors within the Arrays.
 *      The solution sort algorithm is split into two different methods,
 *      doSort and swap methods.
 * 3) Data Structures
 *      The data structure used was an Arraylist.
 * 4) Program description and input/output
 *      This program creates randomized elevator stops and stores the values
 *      in a goingUp array or a goingDown array. Once generated, the output from
 *      the program is the behavior model of an elevator ascending and
 *      descending the floors based on the randomly generated inputs.
 * 5) Class Purpose
 *      The Elevator class holds the program in its entirety.
 *
 * @author kevin Seveur
 * 9/11/2017
 */
public class Elevator {

    final static int NUMBEROFFLOORS = 12; //number of floorsin building
    final static int NUMBEROFSTOPSUP = 8; //number of initial stops going up
    final static int NUMBEROFSTOPSDOWN = 5; // number of initial stos going down
    static ArrayList<Integer> goingUp = new ArrayList<Integer>();
    static ArrayList<Integer> goingDown = new ArrayList<Integer>();
    static int temp = 0;
    static int floor = 0;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        boolean repeat = true;
        Scanner in = new Scanner(System.in);

        while (repeat) {
            repeat = false;
            arrayValsUp();
            doSort("up");
            System.out.print("Up Array       ");
            System.out.println(Arrays.toString(goingUp.toArray()));
            arrayValsDown();
            doSort("down");
            System.out.print("Down Array     ");
            System.out.println(Arrays.toString(goingDown.toArray()));
            ascend();
            transition();
            descend();
            while (floor > 0) {
                noStop(floor, floor - 1);
                floor--;
            }
            System.out.println("Do you want to run the elevator again? "
                    + "“Y or y” continue. “N or n” stop.");
            String usrInput = in.next();
            while (!usrInput.equals("Y") && !usrInput.equals("y")
                    && !usrInput.equals("N") && !usrInput.equals("n")) {
                System.out.println("Please enter \"Y\" or \"N\"");
                usrInput = in.next();
            }
            if (usrInput.equals("y")) {
                repeat = true;
            }
            clearArrays();
        }
        in.close();
    }

    public static void arrayValsUp() {
        for (int idx = 0; idx < NUMBEROFSTOPSUP; idx++) {
            temp =  2 + (int) (Math.random() * NUMBEROFFLOORS - 1);
            if (goingUp.contains(temp)) {
                idx--;
            } else {
                goingUp.add(temp);
            }
    }
}

    public static void arrayValsDown() {
        for (int idx = NUMBEROFSTOPSDOWN - 1; idx >= 0; idx--) {
            temp =  1 + (int) (Math.random() * goingUp.get(goingUp.size() - 1));
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
            for (int idx = 0; idx < goingUp.size() - 1; idx++) {
                min = idx;
                for (int jdx = idx + 1; jdx < goingUp.size(); jdx++) {
                    if (goingUp.get(jdx) < goingUp.get(idx)) {
                        min = jdx;
                        swap(goingUp, idx, min);
                    }
                }
            }
        } else {
           for (int idx = 0; idx < goingDown.size()  - 1; idx++) {
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

    public static void arrayTimer(String p)
            throws InterruptedException {
        if (!p.equals("print") && !p.equals("console")) {
            System.out.println("You must enter print or console for output");
            return;
        }
        Thread thread = new Thread();

        if (p.equals("print")) {
            for (int c = 3; c >= 0; c--) {
                thread.sleep(1000);
                if (c > 1) {
                    System.out.print(c + ", ");
                } else if (c > 0) {
                    System.out.print(c);
                }
            }
        } else {
            for (int c = 2; c >= 0; c--) {
                thread.sleep(1000);            
            }
        }
    }

    public static void noStop(int currentFloor, int nextFloor)
            throws InterruptedException {
        if (currentFloor < nextFloor) {
            System.out.println("Going up: Now at floor " + currentFloor);
        } else {
            System.out.println("Going down: Now at floor " + currentFloor);
        }
        arrayTimer("console");
    }

    public static void nextStop(int nextFloor)
            throws InterruptedException {
        if (nextFloor != 1) {
            System.out.print("Stopping at floor " + nextFloor + " "
                    + "for 3 seconds -> ");
            arrayTimer("print");
            System.out.println();
        } else {
            System.out.println("You have reached floor 1, the ground floor!");
        }
    }

    public static void ascend() throws InterruptedException {
        int maxfloor = goingUp.get(goingUp.size() - 1);
        System.out.println("\nStarting at floor 1");
        for (floor = 1; floor <= maxfloor; floor++) {
            if (floor == goingUp.get(0)) {
                nextStop(floor);
                System.out.println();
                goingUp.remove(0);
                System.out.println("Starting at floor " + floor);
            } else {
                noStop(floor, floor + 1);
                System.out.println();
            }
        }
    }
    public static void descend() throws InterruptedException {
        int minfloor = goingDown.get(goingDown.size() - 1);
        int maxfloor = goingDown.get(0);
        for (floor = maxfloor; floor >= minfloor; floor--) {
            if (floor == goingDown.get(0)) {
                nextStop(floor);
                System.out.println();
                goingDown.remove(0);
                if (floor != 1) {
                System.out.println("Starting at floor " + floor);
                }
            } else {
                noStop(floor, floor - 1);
                System.out.println();
            }
        }
    }

    public static void clearArrays(){
        for (int element = 0; element < goingUp.size(); element++) {
                goingUp.remove(element);
            }
            for (int element = 0; element < goingDown.size(); element++) {
                goingDown.remove(element);
            }
    }
    public static void transition() throws InterruptedException {
        floor--;
        System.out.println("\n-------------Going Down---------------\n ");
        if (floor == goingDown.get(0)) {
            goingDown.remove(0);
        }
        while (floor > goingDown.get(0)) {
            noStop(floor, floor - 1);
            floor--;
        }
    }
}
