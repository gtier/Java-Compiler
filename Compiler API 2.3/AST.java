
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
    /**
     * Constructor for objects of class AST
     */
    public AST()
    {
        // initialise instance variables
    }
    
    public void run(SymbolTable symTab) throws Exception {
        statement.run(symTab);
    }
    
    public String toString() {
        return statement.toString();
    }
    
}
