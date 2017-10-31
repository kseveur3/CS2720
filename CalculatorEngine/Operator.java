/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

/**
 *
 * @author kevinseveur
 */
public class Operator {
    
    final String plus = "+";
    final String minus = "-";
    final String divide = "/";
    final String modulo = "%";
    final String multiply = "*";
    
    
    public static int order(String op) {
        
        int answer = -1;
        switch(op) {
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
    
    public static String symbol(String symbol) {
        switch(symbol) {
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
