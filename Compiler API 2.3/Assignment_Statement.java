
/**
 * Write a description of class Assignment_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment_Statement implements Statement
{
    // instance variables - replace the example below with your own
    private Entry entry;
    private String name;
    private Expression expression;
    private SymbolTable symTab;

    /**
     * Constructor for objects of class Assignment_Statement
     */
    public Assignment_Statement(String newName, Expression newExpression, SymbolTable newSymTab)
    {
        // initialise instance variables
        name = newName;
        expression = newExpression;
        symTab = newSymTab;
    }
    
    public SymbolTable run(SymbolTable newSymTab) throws Exception {
        if (newSymTab != null) {
            symTab = newSymTab;
        }
        try {
            entry = symTab.updateVal(name, expression.evaluate(symTab));
        } catch (Exception e) {
            throw new Exception(e);
        }
        return symTab;
    }
    
    public String toString() {
        return name + "=" + expression.toString();
    }
}
