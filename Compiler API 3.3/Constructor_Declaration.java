import java.util.*;
/**
 * Write a description of class Constructor_Declaration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Constructor_Declaration
{
    // instance variables - replace the example below with your own
    private Identifier identifier;
    private Statement statement;
    private Parameter_List parameters;
    private SymbolTable symTab;
    private SymbolTable constructLocation;
    private String toConstruct;
    
    /**
     * Constructor for objects of class Constructor_Declaration
     */
    public Constructor_Declaration(Identifier newIdentifier, Parameter_List newParameters, Statement newStatement, SymbolTable parent) throws Exception
    {
        // initialise instance variables
        identifier = newIdentifier;
        statement = newStatement;
        parameters =  newParameters;
        symTab = new SymbolTable();
        symTab.setParent(parent);
        statement.setParent(symTab);
        statement.setParentStatement(null);
        statement.setParentMethod(null);
    }
    
    public void construct(List<Object> inputs, String newToConstruct, SymbolTable newConstructLocation) throws Exception {
        toConstruct = newToConstruct;
        if (newConstructLocation != null) {
            constructLocation = newConstructLocation;
        }
        if (inputs.size() != parameters.size()) {
           throw new Exception("Function requires " + parameters.size() + " input(s), but you supplied " + inputs.size() + " input(s)");
        }
        for (int x = 0; x < parameters.size(); x++) {
            if ((inputs.get(x).getClass().equals(parameters.get(x).getType().getType())) == false) {
                throw new Exception("the  type of inputs[" + x + "] does not equal the type of parameter[" + x + "]");
            }
        }
        statement.run();
    }
    
    public void call(List<Object> inputs, String newToUpdate, SymbolTable newReturnLocation) throws Exception {
        toUpdate = newToUpdate;
        if (newReturnLocation != null) {
            returnLocation = newReturnLocation;
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
        for (int i = 0; i < parameters.size(); i++) {
            symTab.deleteVal(parameters.get(i).getIdentifier().getIdentifier());
        }
    }
}
