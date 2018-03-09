
/**
 * Write a description of class Parser here.
 * Can parse very large numerical expressions
 * Give "(3+(5/(2^8)+9)*(10-9)/(17^(9-5))+10/(291098^2-(8091+2091)*(2123/28874*(2+2))))^(3+(5/(2^8)+9)*(10-9)/(17^(9-5))+10)" a try
 * @author (your name)
 * @version (a version number or a date)
 */

public class Parser
{
    // instance variables - replace the example below with your own
    private String myString;

    /**
     * Constructor for objects of class Parser
     */
    public Parser(String newString)
    {
        // initialise instance variables
        myString = newString;
    }
    
    public Numerical_Expression parseNumericalExpression() throws Exception {
        try {
            return recursiveParseNumericalExpression(myString);
        } catch( Exception e) {
            throw new Exception("Big Trouble in parseNumericalExpression: " + e);
            // ?? return ?? assert??
        }
    }
    
    private Numerical_Expression recursiveParseNumericalExpression(String tempString) {
        int tempStringLength = tempString.length(); 
        int parenCount = 0;
        for(int i = tempStringLength - 1; i >= 0; i--) {
            if (tempString.charAt(i) == ')') {
                 parenCount += 1;
            } else if (tempString.charAt(i) == '(') {
                 parenCount -= 1;
            }
            if (parenCount == 0) {
                if (tempString.charAt(i) == '+' || tempString.charAt(i) == '-') {
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
                }
            }
        }
        for(int i = tempStringLength - 1; i >= 0; i--) {
            if (tempString.charAt(i) == ')') {
                 parenCount += 1;
            } else if (tempString.charAt(i) == '(') {
                 parenCount -= 1;
            }
            if (parenCount == 0) {
                if (tempString.charAt(i) == '*' || tempString.charAt(i) == '/') {
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
                }
            }
        }
        for(int i = tempStringLength - 1; i >= 0; i--) {
            if (tempString.charAt(i) == ')') {
                 parenCount += 1;
            } else if (tempString.charAt(i) == '(') {
                 parenCount -= 1;
            }
            if (parenCount == 0) {
                if (tempString.charAt(i) == '^') {
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
                }
            }
        }
        
        if (tempString.charAt(0) == '(' & tempString.charAt(tempStringLength - 1) == ')') {
            String toInput = tempString.substring(1, tempStringLength - 1);
            Numerical_Expression toReturn = recursiveParseNumericalExpression(toInput);
            return toReturn;
        }
        
        return new Numerical_Expression(Double.parseDouble(tempString));
        
    }
}
