import java.util.*;
/**
 * Write a description of class StatementList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatementList implements Statement
{
    // instance variables - replace the example below with your own
    private List<Statement> statementList;
    private SymbolTable symTab;

    /**
     * Constructor for objects of class StatementList
     */
    public StatementList()
    {
        // initialise instance variables
        statementList = new ArrayList<Statement>();
        symTab = new SymbolTable();
    }
    
    public StatementList(List<Statement> newStatementList) {
        statementList = newStatementList;
        symTab = new SymbolTable();
    }
    
    public void add(Statement newStatement) throws Exception {
        statementList.add(newStatement);
    }
    
    public void run() throws Exception {
        for(int i = 0; i < statementList.size(); i++) {
            statementList.get(i).run();
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public String toString() {
        String toReturn = "";
        for(int i = 0; i < statementList.size(); i++) {
            toReturn += statementList.get(i).toString() + System.getProperty("line.separator");
        }
        
        return toReturn;
    }
}
