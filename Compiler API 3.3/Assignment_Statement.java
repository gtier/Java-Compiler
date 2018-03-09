
/**
 * Write a description of class Assignment_Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment_Statement extends Statement
{
    // instance variables - replace the example below with your own
    private Entry entry;
    private String name;
    private Expression expression;
    public SymbolTable symTab;
    private Statement parentStatement;
    private Method_Declaration parentMethod;

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
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public void setParentStatement(Statement newParentStatement) {
        parentStatement = newParentStatement;
    }
    
    public Statement getParentStatement() {
        return parentStatement;
    }
    
    public void setParentMethod(Method_Declaration newParentMethod) {
        parentMethod = newParentMethod;
    }
    
    public Method_Declaration getParentMethod() {
        return parentMethod;
    }
    
    public void execReturn() { 
        if (parentStatement != null) {
            parentStatement.execReturn();
        }
    }
    
    public String toString() {
        return name + "=" + expression.toString();
    }
    
}
