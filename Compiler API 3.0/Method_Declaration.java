import java.util.*;
/**
 * Write a description of class Method_Declaration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Method_Declaration extends Statement
{
    // instance variables - replace the example below with your own
    Type type; 
    Identifier identifier;
    Parameter_List parameters;
    Statement statement;
    SymbolTable symTab;

    /**
     * Constructor for objects of class Method_Declaration
     */
    public Method_Declaration(Type newType, Identifier newIdentifier, Parameter_List newParameters, Statement newStatement, SymbolTable parent) throws Exception
    {
        // initialise instance variables
        type = newType;
        identifier = newIdentifier;
        parameters =  newParameters;
        statement = newStatement;
        symTab = new SymbolTable();
        symTab.setParent(parent);
        statement.getSymTab().setParent(symTab);
        symTab.getParent().addVal(identifier.getIdentifier(), this);
    }
    
    public void run() throws Exception {
        statement.getSymTab().setParent(symTab);
        symTab.getParent().addVal(identifier.getIdentifier(), this);
    }
    
    public void call(List<Object> inputs, SymbolTable returnLocation) throws Exception {
        if (returnLocation != null) {
            symTab.setParent(returnLocation);
        }
        if (inputs.size() != parameters.size()) {
           throw new Exception("Function requires " + parameters.size() + " input(s), but you supplied " + inputs.size() + " input(s)");
        }
        for (int x = 0; x < parameters.size(); x++) {
            if ((inputs.get(x).getClass().equals(parameters.get(x).getType().getType())) == false) {
                throw new Exception("the  type of inputs[" + x + "] does not equal the type of parameter[" + x + "]");
            }
        }
        for (int i = 0; i < parameters.size(); i++) {
            /*
             * Feeding in null for now!
             */
            symTab.addVal(parameters.get(i).getIdentifier().getIdentifier(), inputs.get(i));
        }
        statement.run();
    }
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public String toString() {
        //This is a placeholder!
        return "";
    }
}
