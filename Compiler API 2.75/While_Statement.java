import java.util.*;
/**
 * Write a description of class While_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class While_Statement implements Statement
{
    // instance variables - replace the example below with your own
     private Statement statement;
    public SymbolTable symTab;
    private Boolean_Expression boolExp;
    /**
     * Constructor for objects of class For_Statement
     */
    public While_Statement(Boolean_Expression newBoolExp, Statement newStatement, SymbolTable newParent) throws Exception
    {
        // initialise instance variables
        boolExp = newBoolExp;
        statement = newStatement;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
        statement.getSymTab().setParent(symTab);
    }
    
    public void run() throws Exception {
        if (boolExp.evaluate(symTab) == true) {
            statement.run();
            this.run();
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public String toString() {
        return "";//"for(int i = " + iterator + "; i " + operator + " " + boundry + "; i" + increment + ") {" + System.getProperty("line.separator") + System.getProperty("line.separator") + statement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
    }
}
