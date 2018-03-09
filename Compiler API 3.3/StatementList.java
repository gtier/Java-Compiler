import java.util.*;
/**
 * Write a description of class StatementList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatementList extends Statement
{
    // instance variables - replace the example below with your own
    private List<Statement> statementList;
    private SymbolTable symTab;
    private Statement parentStatement;
    private Method_Declaration parentMethod;
    private boolean isLooping;

    /**
     * Constructor for objects of class StatementList
     */
    public StatementList()
    {
        // initialise instance variables
        statementList = new ArrayList<Statement>();
        symTab = new SymbolTable();
        isLooping = true;
    }
    
    public StatementList(List<Statement> newStatementList) {
        statementList = newStatementList;
        symTab = new SymbolTable();
        isLooping = true;
    }
    
    public void add(Statement newStatement) throws Exception {
        statementList.add(newStatement);
    }
    
    public void run() throws Exception {
        for(int i = 0; i < statementList.size(); i++) {
            if (isLooping == true) {
                statementList.get(i).run();
            } else {
                break;
            }
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setParent(SymbolTable newParent) {
        for(int i = 0; i < statementList.size(); i++) {
            statementList.get(i).getSymTab().setParent(newParent);
        }
    }
    
    public void setParentStatement(Statement newParentStatement) {
        parentStatement = newParentStatement;
        for(int i = 0; i < statementList.size(); i++) { 
            statementList.get(i).setParentStatement(newParentStatement);
        }
    }
    
    public Statement getParentStatement() {
        return parentStatement;
    }
    
    public void setParentMethod(Method_Declaration newParentMethod) {
        parentMethod = newParentMethod;
        for(int i = 0; i < statementList.size(); i++) { 
            statementList.get(i).setParentMethod(newParentMethod);
        }
    }
    
    public Method_Declaration getParentMethod() {
        return parentMethod;
    }
    
    public void execReturn() {
        isLooping = false;
        if (parentStatement != null) {
            parentStatement.execReturn();
        }
    }
    
    public String toString() {
        String toReturn = "";
        for(int i = 0; i < statementList.size(); i++) {
            toReturn += statementList.get(i).toString() + System.getProperty("line.separator");
        }
        
        return toReturn;
    }
}
