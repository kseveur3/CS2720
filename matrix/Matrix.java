
package matrix;
import java.util.Scanner;
/*
 * Kevin Seveur | 002206515
 * CS2720-027
 * 8/25/17
 * 1)Program Purpose:To request a matrix size from the user then add and/or
 *   multiply the two matrices together
 * 2)Algorithm Used: Custom
 * 3)Data Structures Used: None
 * 4)How to use program and expected input/output: The program will prompt
 *   the user for an integer. This integer will be used to create a matrix of
 *   random values. This created matrix will be used in an addtion and a 
 *   multiplication formula to solve.
 * 5)Purpose of each class:
 *   Matrix Class - This is the program
 *   MatrixMath Class - Used to hold all the methods to create random values
 *      for matrices, copy matrix one into matrix2, add the matrices, and 
 *      multiply the matrices.
 */
        

public class Matrix {

    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a single integer to be used as your "
                + "matrix dimensions: ");
        if(!in.hasNextInt()){
            System.out.println("You did not enter an integer!");
            return;
        }
        int usrInput = in.nextInt();
        int matrix[][] = new int[usrInput][usrInput];
        
        int matrix1[][] = MatrixMath.addValues(matrix);
        int matrix2[][] = MatrixMath.arrayCopy(matrix1);
        MatrixMath.matrixAdd(matrix1, matrix2, usrInput);
        MatrixMath.matrixmult(matrix1, matrix2, usrInput);
        
        
    }
    
}
