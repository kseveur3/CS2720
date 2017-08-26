
package matrix;
import java.sql.Timestamp;
import java.util.Random;

/**
 *This class is used to perform addition or multiplication on matrices.
 * @author kevinseveur
 */
public class MatrixMath {
    /**
     * This method creates random integers and adds them to the matrix.
     * @param m1 This is the matrix being passed in
     * @return Returns a matrix with random integers filled in
     */
    public static int[][] addValues(int[][] m1) {
       int[][] matrix = new int[m1.length][m1.length];
       System.out.println("\nHere is your first randomly generated matrix: ");
       for (int row = 0; row < m1.length; row++) {
           for (int column = 0; column < m1[row].length; column++) {
             Random rand = new Random();
             int rval = rand.nextInt(30) + 1;
             matrix[row][column] = rval;
             System.out.printf("%6s", matrix[row][column]);
            }
           System.out.println();
       }
       return matrix;
    }
    /**
     * This method only copies the contents of each element in the matrix
     * to a second matrix.
     * @param m1 The original matrix of which we are copying from
     * @return returns a new second matrix which is a copy of the passed in
     * matrix
     */
    public static int[][] arrayCopy(int[][] m1) {
       int[][] matrix = new int[m1.length][m1.length];
       System.out.println("\nHere is your second randomly generated matrix: ");
       for (int row = 0; row < m1.length; row++) {
           for(int column = 0; column < m1[row].length; column++) {
              matrix[row][column] = m1[row][column];
              System.out.printf("%6s", matrix[row][column]);
            }
           System.out.println();
       }
       return matrix;
    }

    /**
     * This method adds the two matrices together.
     * @param m1 This is the first matrix of which we are adding
     * @param m2 This is the second matrix of which we are adding
     * @param size This is the original matric size passed in by the user
     */
    public static void matrixAdd(int[][] m1, int[][] m2, int size) {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        int[][] addSolution = new int[size][size];
        System.out.println("------------------------------------"
                + "--------------");
        System.out.println("\nHere is your added solution: ");
        for (int row = 0; row < m1.length; row++) {
            for (int column = 0; column < m1[row].length; column++) {
              addSolution[row][column] = m1[row][column] + m2[row][column];

              System.out.printf("%6s", +addSolution[row][column]);
            }
            System.out.println();
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        long millis1 = timestamp1.getTime();
        long millis2 = timestamp2.getTime();
        double duration = millis2 - millis1;
        System.out.printf("\nRunning Time for MatrixAdd in milliseconds:%.4f ",
                duration);
        System.out.println();
        System.out.println();
    }

    /**
     * This method multiplies the matrices together.
     * @param m1 This is the first matrix of which we are multiplying
     * @param m2 This is the second matrix of which we are multiplying
     * @param size This is the original matric size passed in by the user
     */
    public static void matrixmult(int[][] m1, int[][] m2, int size) {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        int[][] addSolution = new int[size][size];
        int value = 0;
        System.out.println("------------------------------------"
                + "--------------");
        System.out.println("Here is your multiplied solution: ");

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
              for (int k = 0; k < m1.length; k++) {
                  value += m1[i][k] * m2[k][j];
              }
              addSolution[i][j] = value;
              value = 0;

              System.out.printf("%6s", +addSolution[i][j]);
            }
            System.out.println();
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        long millis1 = timestamp1.getTime();
        long millis2 = timestamp2.getTime();
        double duration = millis2 - millis1;
        System.out.printf("\nRunning Time for MatrixMult in milliseconds:%.4f ",
                duration);
        System.out.println();
        System.out.println();
    }
}
