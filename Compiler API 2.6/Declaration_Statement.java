
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
    public SymbolTable symTab;  // in Declarations, we do not "new" this symtab, just refer to some external symtab
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
            entry = symTab.addVal(name, value.evaluate(symTab));
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
        return "New entry " + name + ": " + value.toString();
    }
}
