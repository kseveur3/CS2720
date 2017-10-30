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
public class calc {
    public static Stack<Integer> data = new Stack<Integer>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        String equation;
        String response;

        while (repeat) {
            
            System.out.println("Please enter an equation to solve!");
            equation = in.nextLine();
            calculator(infixToPostfix(equation));
            //infixToPostfix("5*(10%3)+2*3*(6/2)");
            String postfix1 = "5 10 3 % 2 + 3 * 6 2 / * * ";
            String postfix2 = "5 X +";
            String postfix3 = "8 10 2 / +";
           //calculator(postfix2);
           //equation = null;
            
            System.out.println("Do you have another equation to solve? "
                    + "Yes or No?");
            response = in2.next();
            if ("No".equals(response)) {
                repeat = false;
            }
        }
    }
    
    private static int currentMemory() { return data.peek(); }
    
    private static void pushOperand(int value) { data.push(value);} 
    
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
    
    private static void calculator(String x)
     {
         boolean repeat = true;
         
         while (repeat){
         int intval;
         calc calc = new calc();
         char c;
         int i = 0;
         int j = 0;
         String input ="";
         String varX = "";
         boolean noX = true;
         Scanner in = new Scanner(System.in); 
         String z = x;
         
         if ( x.contains("X")) {
             System.out.println("Please enter your value for \"x\" or "
                     + "\"q\" to quit: ");
             varX = in.next();   
             z = x.replaceAll("X", varX); 
         } else {
             noX = false;
         }
         
         varX = "";

      while (i < z.length()) {
         c = z.charAt(i);
         switch (c) {
             
           case '0': case '1': case '2': case '3': case '4':
           case '5': case '6': case '7': case '8': case '9':
               //preInput += c;
               input += c;
               //System.out.println("Input so far: " + input);
               //intval = Integer.parseInt(input);     
               //calc.pushOperand(intval);

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
            System.out.println("Answer to expression: " + calc.currentMemory());
            System.out.println();
         while (!calc.data.empty()) {
             calc.data.pop();
         }
         }
         if (noX == false) {
             repeat = false;     
         }
     }
     }

    private static String opString(String theOp)
     {
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
    
    private static String processOp(String theOp,
                        Stack< String> opStack, String result) { 
        
       if ((!opStack.empty()) && ((Operator.order(theOp)) <= 
               (Operator.order(opStack.peek())))) {
         result += opString(opStack.peek());
         opStack.pop();
       }
       opStack.push(theOp);
       return result;
     }
    
    private static String infixToPostfix(String infixStr) {
       Stack<String> opStack = new Stack<>();
       String result = "";
       int i = 0;
       infixStr = infixStr.toUpperCase();

       while (i < infixStr.length() ) {
         if ((Character.isDigit(infixStr.charAt(i))) || (infixStr.charAt(i) == 'X')) {
           while ((i < infixStr.length()) && 
                   ((Character.isDigit(infixStr.charAt(i)))
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
}
