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

    /**
     * Constructor for objects of class StatementList
     */
    public StatementList()
    {
        // initialise instance variables
        statementList = new ArrayList<Statement>();
    }
    
    public StatementList(List<Statement> newStatementList) {
        statementList = newStatementList;
    }
    
    public void add(Statement newStatement) throws Exception {
        statementList.add(newStatement);
    }
    
    public void run() throws Exception {
        for(int i = 0; i < statementList.size(); i++) {
            statementList.get(i).run();
        }
    }
    
}
