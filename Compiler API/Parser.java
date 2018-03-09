
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
    
    private Numerical_Expression recursiveParseNumericalExpression(String tempString) throws Exception {
        int tempStringLength = tempString.length();
        int parenCount = 0;
        for(int i = tempStringLength - 1; i >= 0; i--) {
            Numerical_Expression expressionToEvaluate;
            double expressionValue;
            boolean found;
            found = false;
            if (tempString.charAt(i) == ')') {
                parenCount = 1;
                for (int w = tempStringLength - ((tempStringLength - (i)) + 1); w >= 0; w--) {
                    if (found == false) {
                        if (tempString.charAt(w) == ')') {
                            parenCount += 1;
                        } else if (tempString.charAt(w) == '(') {
                            parenCount -= 1;
                        }
                        if (parenCount == 0) {
                            expressionToEvaluate = recursiveParseNumericalExpression(tempString.substring(w+1, tempStringLength - ((tempStringLength - (i)))));
                            expressionValue = expressionToEvaluate.evaluate();
                            tempString = tempString.substring(0, w) + String.valueOf(expressionValue) + tempString.substring(tempStringLength - ((tempStringLength - (i))) + 1);
                            found = true;
                            return recursiveParseNumericalExpression(tempString);
                        }
                    }
                }
            }
            if (tempString.charAt(i) == '+' || tempString.charAt(i) == '-') {
                return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
            }
        }
        for(int i = tempStringLength - 1; i > 0; i--) {
            if (tempString.charAt(i) == '*' || tempString.charAt(i) == '/') {
                return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
            }
        }
        for(int i = tempStringLength - 1; i > 0; i--) {
            if (tempString.charAt(i) == '^') {
                return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseNumericalExpression(tempString.substring(0, i)), recursiveParseNumericalExpression(tempString.substring(i + 1)));
            }
        }
        try {
            return new Numerical_Expression(Double.parseDouble(tempString));
        } catch( Exception e ) {
            throw new Exception("Error in recursiveParseNumericalExpression: " + e);
        }
    }
}
