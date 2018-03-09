
/**
 * Write a description of class AST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AST
{
    // instance variables - replace the example below with your own
    private Statement statement;
    private SymbolTable symTab;
    /**
     * Constructor for objects of class AST
     */
    public AST()
    {
        // initialise instance variables
        symTab = new SymbolTable();
    }
    
    public void run() throws Exception {
        statement.run();
    }
    
    public String toString() {
        return statement.toString();
    }
    
}
