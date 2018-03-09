import java.util.*;
/**
 * Write a description of class For_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class For_Statement extends Loop_Statement
{
    // instance variables - replace the example below with your own
    private Statement statement;
    public SymbolTable symTab;
    private Boolean_Expression boolExp;
    private List<Assignment_Statement> onIterate;
    private List<Declaration_Statement> vars;
    private Boolean stopLoop;
    private Statement parentStatement;
    private Method_Declaration parentMethod;
    
    /**
     * Constructor for objects of class For_Statement
     */
    public For_Statement(List<Declaration_Statement> newVars, Boolean_Expression newBoolExp, List<Assignment_Statement> newOnIterate, Statement newStatement, SymbolTable newParent) throws Exception
    {
        // initialise instance variables
        boolExp = newBoolExp;
        statement = newStatement;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
        statement.setParent(symTab);
        vars = newVars;
        onIterate = newOnIterate;
        for (int i = 0; i < vars.size(); i++) {
            vars.get(i).setSymTab(symTab);
            vars.get(i).run();
        }
        stopLoop = false;
        statement.setParentStatement(this);
        statement.setParentMethod(parentMethod);
    }
    
    public void run() throws Exception {
        if ((boolExp.evaluate(symTab)) == true && (stopLoop == false)) {
            statement.run();
            for (int i = 0; i < onIterate.size(); i++) {
                onIterate.get(i).setSymTab(symTab);
                onIterate.get(i).run();
            }
            this.run();
        }
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
    
    public String toString() {
        return "";//"for(int i = " + iterator + "; i " + operator + " " + boundry + "; i" + increment + ") {" + System.getProperty("line.separator") + System.getProperty("line.separator") + statement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
    }
    
    public void stop() {
        stopLoop = true;
    }
    
    public void execReturn() {
        stopLoop = true;
        if (parentStatement != null) {
            parentStatement.execReturn();
        }
    }
}
