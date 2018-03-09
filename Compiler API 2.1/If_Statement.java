
/**
 * Write a description of class If_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class If_Statement extends Statement
{
    // instance variables - replace the example below with your own
    private Boolean_Expression boolExp;
    private Statement trueStatement;
    private Statement falseStatement;
    private SymbolTable symTab;

    /**
     * Constructor for objects of class If_Statement
     */
    public If_Statement(Boolean_Expression newBoolExp, Statement newTrueStatement, SymbolTable newSymTab)
    {
        // initialise instance variables
        boolExp = newBoolExp;
        trueStatement = newTrueStatement;
        symTab = newSymTab;
    }
    
    public If_Statement(Boolean_Expression newBoolExp, Statement newTrueStatement, Statement newFalseStatement, SymbolTable newSymTab)
    {
        // initialise instance variables
        boolExp = newBoolExp;
        trueStatement = newTrueStatement;
        falseStatement = newFalseStatement;
        symTab = newSymTab;
    }
    
    public void run() throws Exception {
        Boolean boolCase = boolExp.evaluate(symTab);
        if (boolCase == true) {
            trueStatement.run();
        } else if ((boolCase == false) && (falseStatement != null)) {
            falseStatement.run();
        }
    }
}
