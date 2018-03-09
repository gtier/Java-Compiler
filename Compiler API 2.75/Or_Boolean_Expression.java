
/**
 * Write a description of class Or_Boolean_Expression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Or_Boolean_Expression implements Expression
{
    // instance variables - replace the example below with your own
    private Boolean_Expression leftSide, rightSide;
    private Boolean value;
    
    /**
     * Constructor for objects of class Or_Boolean_Expression
     */
    public Or_Boolean_Expression(Boolean_Expression newLeftSide, Boolean_Expression newRightSide)
    {
        // initialise instance variables
        leftSide = newLeftSide;
        rightSide = newRightSide;
    }
    
    public Boolean evaluate(SymbolTable symTab) throws Exception {
        if (leftSide.evaluate(symTab) || rightSide.evaluate(symTab)){
            return true;
        } else {
            return false;
        }
    }
}
