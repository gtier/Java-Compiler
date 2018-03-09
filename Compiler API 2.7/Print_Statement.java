
/**
 * Write a description of class Print_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Print_Statement implements Statement
{
    // instance variables - replace the example below with your own
    private Object obj;
    private String variable;
    public SymbolTable symTab;
    /**
     * Constructor for objects of class Print_Statement
     */
    public Print_Statement(Object newObj)
    {
        // initialise instance variables
        symTab = new SymbolTable();
        obj = newObj;
    }
    
    public Print_Statement(String newVariable, SymbolTable newParent) throws Exception {
        variable = newVariable;
        symTab = new SymbolTable();
        if (newParent != null) {
            symTab.setParent(newParent);
        }
    }
    
    public void run() throws Exception {
        if(variable != null) {
            if(symTab != null) {
                obj = lookForEntry(symTab, variable);
            }
        }
        System.out.println(obj.toString());
    }
    
    private Entry lookForEntry(SymbolTable symTab, String var) throws Exception {
        Entry temp;
        String tempString;
        try {
            temp = symTab.getVal(var);
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        if (temp != null) {
            return temp;
        } else { // temp==null...
            SymbolTable symTabParent = symTab.getParent();
            if (symTabParent == null) {
                // okay, end of the line, no more symbol tables above this, so the variable isn't findable..
                throw new VariableNotFoundException("Error in lookForEntry: " + var + " could not be found");
            } else {
              return lookForEntry(symTabParent, var);
            }
        }
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public String toString() {
        if(variable != null) {
            if(symTab != null) {
                return "Print(" + variable + ")";
            }
        }
        return "Print(" + obj.toString() + ")";
    }
}
