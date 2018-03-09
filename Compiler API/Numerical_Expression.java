
/**
 * Write a description of class Numerical_Expression here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Numerical_Expression
{
    // instance variables - replace the example below with your own
    private String operator;
    private Numerical_Expression leftSide;
    private Numerical_Expression rightSide;
    private double constantValue;

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
    
    public Numerical_Expression(double newValue){
        constantValue = newValue;
    }
    
    public double evaluate() throws Exception{
        if(operator == null){
            return constantValue;
        } else if (operator.equals("+")){
            return leftSide.evaluate() + rightSide.evaluate();
        } else if(operator.equals("-")){
            return leftSide.evaluate() - rightSide.evaluate();
        } else if(operator.equals("*")){
            return leftSide.evaluate() * rightSide.evaluate();
        } else if(operator.equals("/")){
            return leftSide.evaluate() / rightSide.evaluate();
        } else if(operator.equals("^")) {
           return  (double)Math.pow(leftSide.evaluate(), rightSide.evaluate());
        } else {
           throw new Exception("Error in evaluate: operator " + operator + " is invalid");
        }
    }
}
