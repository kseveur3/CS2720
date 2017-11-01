/**
 * 1) The purpose of this class is to establish order of operations as well as
 * to manage conversion from operator to text  equivalent of the operator.
 *
 * @author kevin Seveur
 * 10/29/2017
 */


package calc;

public class Operator {

    /**
     * Postcondition - returns a value that represents the order of operations.
     * @param op
     * @return An integer representation of the order o operations.
     */
    public static int order(String op) {

        int answer = -1;
        switch (op) {
            case "*": answer = 1; break;
            case "multiply": answer = 1; break;
            case "/": answer = 1; break;
            case "divide": answer = 1; break;
            case "%": answer = 1; break;
            case "modulo": answer = 1; break;
            case "+": answer = 2; break;
            case "plus": answer = 2; break;
            case "-": answer = 2; break;
            case "minus": answer = 2; break;
            default: answer = 0;
        }
        return answer;
    }

    /**
     * @param symbol
     * @return String that represents the operator entered.
     */
    public static String symbol(String symbol) {
        switch (symbol) {
            case "*": return "multiply";
            case "/": return "divide";
            case "%": return "modulo";
            case "+": return "plus";
            case "-": return "minus";
            default: System.out.println("Bad Operator given2!");
        }
        return "";
    }

}
