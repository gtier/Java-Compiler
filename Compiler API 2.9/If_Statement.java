
/**
 * Write a description of class If_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class If_Statement implements Statement
{
    // instance variables - replace the example below with your own
    private Boolean_Expression boolExp;
    private Statement trueStatement;
    private Statement falseStatement;
    public SymbolTable symTab;

    /**
     * Constructor for objects of class If_Statement
     */
    public If_Statement(Boolean_Expression newBoolExp, Statement newTrueStatement, SymbolTable newParent)
    {
        // initialise instance variables
        boolExp = newBoolExp;
        trueStatement = newTrueStatement;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
        trueStatement.setParent(symTab);
    }
    
    public If_Statement(Boolean_Expression newBoolExp, Statement newTrueStatement, Statement newFalseStatement, SymbolTable newParent)
    {
        // initialise instance variables
        boolExp = newBoolExp;
        trueStatement = newTrueStatement;
        falseStatement = newFalseStatement;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
        trueStatement.setParent(symTab);
        falseStatement.setParent(symTab);
    }
    
    public void run() throws Exception {
        Boolean boolCase = boolExp.evaluate(symTab);
        if (boolCase == true) {
            trueStatement.run();
        } else if ((boolCase == false) && (falseStatement != null)) {
            falseStatement.run();
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public String toString() {
       if (falseStatement == null) {
            return "if ( " + boolExp.toString() + " ) {" + System.getProperty("line.separator") + System.getProperty("line.separator") + trueStatement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
        } else {
            return "if ( " + boolExp.toString() + " ) {" + System.getProperty("line.separator") + System.getProperty("line.separator") + trueStatement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "} else {" + System.getProperty("line.separator") + System.getProperty("line.separator") + falseStatement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
        }
    }
}
