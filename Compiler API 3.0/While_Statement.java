import java.util.*;
/**
 * Write a description of class While_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class While_Statement  extends Loop_Statement
{
    // instance variables - replace the example below with your own
     private Statement statement;
    public SymbolTable symTab;
    private Boolean_Expression boolExp;
    private Boolean stopLoop;
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
        statement.setParent(symTab);
        stopLoop = false;
    }
    
    public void run() throws Exception {
        if ((boolExp.evaluate(symTab) == true) && (stopLoop == false)) {
            statement.run();
            this.run();
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public String toString() {
        return "";//"for(int i = " + iterator + "; i " + operator + " " + boundry + "; i" + increment + ") {" + System.getProperty("line.separator") + System.getProperty("line.separator") + statement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
    }
    public void stop() {
        stopLoop = true;
    }
}
