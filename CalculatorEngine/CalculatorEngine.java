/**
 * 1) Program Purpose
 *      This program allows is a phone directory that allows a user to 
 *      enter names and phone numbers into directory.
 * 2) Solution and Algorithms
 *      My solution involved utilizing the Java library for the LinkedList 
 *      data structure. I also created an algorithm to manage placement of new
 *      phone book nodes into the LinkedLists.
 * 3) Data Structures
 *      The only data structure used was a LimkedList.
 * 4) Program description and input/output
 *      This program is a phone book that stores names and phone numbers for 
 *      contacts. It will store the phone book entries alphabetically 
 *      based on last name, then first name, then phone number. It will 
 *      only allow unique phone numbers into the list.
 * 5) Class Purpose
 *      This class is the main program for the phone directory program.
 *
 * @author kevin Seveur
 * 10/15/2017
 */
package calculatorengine;

import java.util.Stack;
import java.util.Scanner;




/**
 *
 * @author kevinseveur
 */
public class CalculatorEngine {
    public static Stack<Integer> data = new Stack<Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        String equation;
        String response;
        while (repeat) {
            System.out.println("Please enter an equation to solve!");
            equation = in.nextLine();
            calculator(equation);
            
            System.out.println("Do you have another equation to solve? "
                    + "Yes or No?");
            response = in.next();
            if (response == "No") {
                repeat = false;
            }
        }
        
        

        // Add Code Here
    }
    
    private static int currentMemory() { return data.peek(); }
    
    private static void pushOperand(int value) { data.push(value);} 
    
    private static void doOperator(String theOp) {
        //String theOp = Operator.symbol(Op);
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
    
    private static void calculator(String x)
     {
       int intval;
       CalculatorEngine calc = new CalculatorEngine();
       char c;
       int i = 0;
      String input =" ";
      while (i < x.length()) {
         c = x.charAt(i);
         switch (c) {
           case '0': case '1': case '2': case '3': case '4':
           case '5': case '6': case '7': case '8': case '9':
          input +=c;
           intval = Integer.parseInt(input);     
           calc.pushOperand(intval);
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
       }
     }

    
    
}

    

    
    

