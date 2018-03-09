
/**
 * Write a description of class Numerical_Expression here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numerical_Expression implements Expression
{
    // instance variables - replace the example below with your own
    private String operator;
    private Numerical_Expression leftSide;
    private Numerical_Expression rightSide;
    private Double constantValue;
    private String variable;
    private boolean isVariable;
    private boolean constant;

    /**
     * Constructor for objects of class Numeric_expression
     */
    public Numerical_Expression(String newOperator, Numerical_Expression newLeftSide, Numerical_Expression newRightSide)
    {
        // initialise instance variables
        operator = newOperator;
        leftSide = newLeftSide;
        rightSide = newRightSide;
        
    }
    
    public Numerical_Expression(Double newValue){
        constantValue = newValue;
        constant = true;
    }
    
    public Numerical_Expression(String newVariable){
        isVariable = true;
        variable = newVariable;
    }
    public Double evaluate(SymbolTable symTab) throws Exception {
        if(constant){
            return constantValue;
        } else if (isVariable) {
            try {
                String temp;
                try {
                    temp = lookForEntry(symTab, variable);
                } catch (Exception e) {
                    throw new Exception(e);
                }
                Double toReturn = Double.parseDouble(temp);
                return toReturn;
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else if (operator.equals("+")){
            return leftSide.evaluate(symTab) + rightSide.evaluate(symTab);
        } else if(operator.equals("-")){
            return leftSide.evaluate(symTab) - rightSide.evaluate(symTab);
        } else if(operator.equals("*")){
            return leftSide.evaluate(symTab) * rightSide.evaluate(symTab);
        } else if(operator.equals("/")){
            return leftSide.evaluate(symTab) / rightSide.evaluate(symTab);
        } else if(operator.equals("^")) {
           return  (Double)Math.pow(leftSide.evaluate(symTab), rightSide.evaluate(symTab));
        } else {
           throw new Exception("Error in evaluate: operator " + operator + " is invalid");
        }
    }
    public String toString() {
        if (constant == true) {
            return constantValue.toString();
        }
        
        if (isVariable) {
            return variable;
        }
        
        return "(" + leftSide.toString() + operator + rightSide.toString() + ")";
    }
    
    private String lookForEntry(SymbolTable symTab, String var) throws Exception {
        Entry temp;
        String tempString;
        try {
            temp = symTab.getVal(var);
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        if (temp != null) {
            try {
                tempString = temp.getValue().toString();
            } catch (Exception e) {
                throw new Exception(e);
            }
            return tempString;
        } else { // temp==null...
            SymbolTable symTabParent = symTab.getParent();
            if (symTabParent == null) {
                // okay, end of the line, no more symbol tables above this, so the variable isn't findable..
                throw new VariableNotFoundException("Error in lookForEntry: " + var + " could not be found");
            } else {
              return lookForEntry(symTabParent, var);
            }
        }
    }
}
