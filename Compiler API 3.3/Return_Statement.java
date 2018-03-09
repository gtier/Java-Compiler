
/**
 * Write a description of class Return_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Return_Statement extends Statement
{
    // instance variables - replace the example below with your own
    private SymbolTable symTab;
    private Statement parentStatement;
    private Method_Declaration parentMethod;
    private Expression toReturn;
    
    public Return_Statement(Expression newToReturn) {
        symTab = new SymbolTable();
        toReturn = newToReturn;
    }
    
    public void run() throws Exception {
        if (parentStatement != null) {
            parentStatement.execReturn();
        }
        parentMethod.returnLocation.updateVal(parentMethod.toUpdate , toReturn.evaluate(symTab));
    }
    
    public SymbolTable getSymTab() {
        return symTab;
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
        //This is a placeholder!
        return "";
    }
}
