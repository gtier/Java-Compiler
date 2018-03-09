
/**
 * Write a description of class Declaration_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Declaration_Statement implements Statement
{
    // instance variables - replace the example below with your own
    private Entry entry;
    private SymbolTable symTab;
    private String name;
    private Expression value;

    /**
     * Constructor for objects of class Declaration_Statement
     */
    public Declaration_Statement(String newName, Expression newValue, SymbolTable newSymTab)
    {
        // initialise instance variables
        symTab = newSymTab;
        name = newName;
        value = newValue;
    }
    
    public void run() throws Exception {
        try {
            entry = symTab.addVal(name, value);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public String toString() {
        return "New entry " + name + ": " + value.toString();
    }
}
