
/**
 * Write a description of class Parse_Num_Exp_Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parse_Num_Exp_Module extends Parse_Module
{
    // instance variables - replace the example below with your own
    String myString;
    /**
     * Constructor for objects of class Parse_Num_Exp_Module
     */
    public Parse_Num_Exp_Module(String newString)
    {
        // initialise instance variables
        myString = newString;
    }
    
    public Numerical_Expression parse() throws Exception {
        try {
            return recursiveParseStep(myString);
        } catch( Exception e) {
            throw new Exception("Error in Parse_Num_Exp_Module.parse(): " + e);
        }
    }
    
    private Numerical_Expression recursiveParseStep(String tempString) {
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
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseStep(tempString.substring(0, i)), recursiveParseStep(tempString.substring(i + 1)));
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
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseStep(tempString.substring(0, i)), recursiveParseStep(tempString.substring(i + 1)));
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
                    return new Numerical_Expression(String.valueOf(tempString.charAt(i)), recursiveParseStep(tempString.substring(0, i)), recursiveParseStep(tempString.substring(i + 1)));
                }
            }
        }
        
        if (tempString.charAt(0) == '(' & tempString.charAt(tempStringLength - 1) == ')') {
            String toInput = tempString.substring(1, tempStringLength - 1);
            Numerical_Expression toReturn = recursiveParseStep(toInput);
            return toReturn;
        }
        
        try {
            return new Numerical_Expression(Double.parseDouble(tempString));
        } catch (Exception e ) {
            return new Numerical_Expression(tempString);
        }
        
    }
}
