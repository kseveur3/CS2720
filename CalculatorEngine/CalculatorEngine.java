/**
 * 1) Program Purpose
 *      This program is a calculator that converts an infix expression to
 *      postfix before outputting
 *      the answer.
 * 2) Solution and Algorithms
 *      My solution involved utilizing the Java library version of a Stack
 *      data structure. I also created an algorithm to manage ensuring
 *      equations are input as
 *      infix with spaces between each value.
 * 3) Data Structures
 *      The only data structure used was a Stack.
 * 4) Program description and input/output
 *      This program is a calculator that takes an infix expression as the
 *      output and returns
 *      a solution to the equation.
 * 5) Class Purpose
 *      This class is the main program for the calculator program.
 *
 * @author kevin Seveur
 * 10/29/2017
 */


package calc;

import java.util.Stack;
import java.util.Scanner;




public class calc {
    public static Stack<Integer> data = new Stack<Integer>();

    static int temp = 0;

    public static void main(String[] args) {

        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        String equation;
        String response;

        while (repeat) {

            System.out.println("\nPlease enter an equation to solve,\"p\" "
                    + "to print the value of the previous equation, or \"q\" "
                    + "to quit!");
            equation = in.nextLine();

            if (equation.equals("p")) {
                if (temp != 0) {
                    System.out.println("Answer to previous expression: "
                            + temp);
                } else {
                    System.out.println("No answer to display");
                }
            } else if (equation.equals("q")) {
                repeat = false;
                break;
            } else if (validator(equation) == 1) {
                calculator(infixToPostfix(equation));
                System.out.print("Do you have another equation to solve? "
                        + "Yes or No?");
                response = in2.next();
                if ("No".equals(response)) {
                    repeat = false;
                }
            }
        }
    }

    /**
     * Precondition - Stack is instantiated and has a value in it.
     * Postcondition - Returns the value atop the stack.
     */
    private static int currentMemory() { return data.peek(); }

    /**
     * Precondition - Stack is instantiated.
     * Postcondition - pushes the "value" onto the stack
     * @param value
     */
    private static void pushOperand(int value) { data.push(value);}

    /**
     * Precondition - The stack is created and has data values in it.
     * Postcondition - Returns the completed equation.
     * @param theOp
     */
    private static void doOperator(String theOp) {
        int right = data.peek();
        data.pop();
        int left = data.peek();
        data.pop();
        int result = -1;
        switch (theOp) {
            case "plus":
                result = left + right;
                break;
            case "minus":
                result = left - right;
                break;
            case "multiply":
                result = left * right;
                break;
            case "divide":
                result = left / right;
                break;
            case "modulo":
                result = left % right;
        }

        data.push(result);
    }

    /**
     * Precondition - A postfix equation is entered as a parameter.
     * Postcondition - The result of the completed equation is the last value 
     * on the stack.
     * @param x
     */
    private static void calculator(String x) {
        boolean repeat = true;

        while (repeat) {
            int intval;
            calc calc = new calc();
            char c;
            int i = 0;
            int j = 0;
            String input = "";
            String varX = "";
            boolean noX = true;
            Scanner in = new Scanner(System.in);
            String z = x;


            if (x.contains("X")) {
                System.out.print("\nPlease enter your value for \"x\" or "
                        + "\"q\" to quit: ");
                varX = in.next();
                z = x.replaceAll("X", varX);
            } else {
                noX = false;
            }

            while (i < z.length()) {
                c = z.charAt(i);
                switch (c) {

                    case '0': case '1': case '2': case '3': case '4':
                    case '5': case '6': case '7': case '8': case '9':
                        input += c;
                        break;

                    case ' ':
                        if (!input.equals("")) {
                            intval = Integer.parseInt(input);
                            calc.pushOperand(intval);
                            input = "";
                        }
                        break;

                    case '+':
                        calc.doOperator("plus");
                        break;

                    case '-':
                        calc.doOperator("minus");
                        break;

                    case '*':
                        calc.doOperator("multiply");
                        break;

                    case '/':
                        calc.doOperator("divide");
                        break;

                    case '%':
                        calc.doOperator("modulo");
                        break;

                    case 'p':
                        System.out.println(calc.currentMemory());
                        break;

                    case 'q': return;
                }
                i++;
            }
            if (!calc.data.empty()) {
                System.out.println("Answer to expression: "
                        + calc.currentMemory());
                System.out.println();
                temp = calc.currentMemory();
                while (!calc.data.empty()) {
                    calc.data.pop();
                }
            }
            if (!noX) {
                repeat = false;
            }
        }
    }

    /**
     * @param theOp
     * @return
     */
    private static String opString(String theOp) {
        String operation = "";
        switch (theOp) {
            case "plus": operation = "+ "; break;
            case "minus": operation = "- "; break;
            case "multiply": operation = "* "; break;
            case "divide": operation = "/ "; break;
            case "modulo": operation = "% "; break;

        }
        return operation;
    }


    /**
     * Precondition - Stack is initialized.
     * Postcondition - Pushes the operator onto the stack based on order of
     *                  operations.If theOp parameter is lower or equal to
     *                  operator atop the stack, theOp replaces the operator
     *                  atop the stack.
     * @param theOp
     * @param opStack
     * @param result
     * @return
     */
    private static String processOp(String theOp,
                                    Stack< String> opStack, String result) {

        if ((!opStack.empty()) && ((Operator.order(theOp))
                <= (Operator.order(opStack.peek())))) {
            result += opString(opStack.peek());
            opStack.pop();
        }
        opStack.push(theOp);
        return result;
    }


    /**
     * Precondition - an infix equation is passed in as a parameter.
     * Postcondition - The infix equation is converted to postfix.
     * @param infixStr
     * @return
     */
    private static String infixToPostfix(String infixStr) {
        Stack<String> opStack = new Stack<>();
        String result = "";
        int i = 0;
        infixStr = infixStr.toUpperCase();

        while (i < infixStr.length()) {
            if ((Character.isDigit(infixStr.charAt(i)))
                    || (infixStr.charAt(i) == 'X')) {
                while ((i < infixStr.length())
                        && ((Character.isDigit(infixStr.charAt(i)))
                                || (infixStr.charAt(i) == 'X'))) {
                    result += infixStr.charAt(i);
                    i++;
                }
                result += " ";
            } else {
                switch (infixStr.charAt(i)) {
                    case '(':
                        opStack.push("leftparen");
                        break;
                    case ')':
                        while (opStack.peek().compareTo("leftparen") != 0) {
                            result += opString(opStack.peek());
                            opStack.pop();
                        }
                        opStack.pop();
                        break;
                    case '+':
                        result = processOp("plus", opStack, result);
                        break;
                    case '-':
                        result = processOp("minus", opStack, result);
                        break;
                    case '*':
                        result = processOp("multiply", opStack, result);
                        break;
                    case '/':
                        result = processOp("divide", opStack, result);
                        break;
                    case '%':
                        result = processOp("modulo", opStack, result);
                        break;
                }
                i++;
            }
        }
        while (!opStack.empty()) {
            result += opString(opStack.peek());
            opStack.pop();
        }
        System.out.println("\nConverted expression: " + result);
        return result;
    }

    /**
     * Precondition - User has input an equation.
     * Postcondition - Input equation has been validated to ensure proper
     *                  format for processing.
     * @param usrInput
     * @return
     */
    public static int validator(String usrInput) {
        String operators = "+ - * / %";
        String operands = "1 2 3 4 5 6 7 8 9 0 x";
        String paren = "( )";
        int lParens = 0;
        int rParens = 0;
        int check = 1;
        String modInput = usrInput;


        if (usrInput.contains("((")) {
            modInput = modInput.replace("((", "( (");
        }
        if (usrInput.contains("))")) {
            modInput = modInput.replace("))", ") )");
        }

        String[] newString = modInput.split("\\s");


        if (usrInput.contains(".")) {
            System.out.println("Error in expression!! Cannot accept floating"
                    + " point numbers.");
            check = -1;
            return check;
        }

        if (newString.length > 2) {
            for (int i = 0; i < newString.length; i++) {
                if (newString[i].length() > 1) {
                    System.out.println("Error in expression!! Please include"
                            + " spaces between each operand and each"
                            + " operator!");
                    check = -1;
                    return check;
                }
                if (newString[i].equals("(")) {
                    lParens++;
                }
                if (newString[i].equals(")")) {
                    rParens++;
                }

                if (((operators.indexOf(newString[i]) != -1) 
                        && (operators.indexOf(newString[i + 1]) != -1))) {
                    System.out.println("Error in expression!! The "
                            + newString[i] + " operator cannot be preceded by a"
                            + " " + newString[i + 1] + " operator.");
                    check = -1;
                    return check;
                } else if ((i < newString.length - 2)
                        && (operands.indexOf(newString[i]) != -1) 
                        && (operands.indexOf(newString[i+1]) != -1)
                        && (operators.indexOf(newString[i+2]) != -1)) {
                    System.out.println("Error in expression!! No operator"
                            + " between operands. Also last token must be"
                            + " an operand.");
                    check = -1;
                    return check;
                } else if ((i < newString.length - 1)
                        && ((operands.indexOf(newString[i]) != -1) 
                        && (newString[i + 1].equals("(")))) {
                    System.out.println("Error in expression!! No operator"
                            + " between operand and left parentheses.");
                    check = -1;
                    return check;
                }
            }

            if (lParens < rParens) {
                System.out.println("Error in expression!! No matching"
                        + " left parentheses for a right parentheses.");
                check = -1;
                return check;
            }
            if (lParens > rParens) {
                System.out.println("Error in expression!! No matching right"
                        + " parentheses for a left parentheses.");
                check = -1;
                return check;
            }
        } else {
            System.out.println("Error in expression!! Your expression does"
                    + " not contain 2 operands and an operator!");
            check = -1;
        }
        return check;
    }
}
