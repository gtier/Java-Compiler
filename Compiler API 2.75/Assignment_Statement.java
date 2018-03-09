
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
    public SymbolTable symTab;

    /**
     * Constructor for objects of class Assignment_Statement
     */
    public Assignment_Statement(String newName, Expression newExpression, SymbolTable newParent)
    {
        // initialise instance variables
        name = newName;
        expression = newExpression;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
    }
    
    public void run() throws Exception {
        try {
            entry = symTab.updateVal(name, expression.evaluate(symTab));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setSymTab(SymbolTable newSymTab) {
        symTab = newSymTab;
    }
    
    public String toString() {
        return name + "=" + expression.toString();
    }
}
