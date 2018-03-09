import java.util.*;
/**
 * Write a description of class Class_Declaration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class_Declaration
{
    // instance variables - replace the example below with your own
    private List<Method_Declaration> methods;
    private List<Declaration_Statement> instanceVariables;
    private List<Constructor_Declaration> constructors;
    private Identifier identifier;
    private SymbolTable symTab;
    

    /**
     * Constructor for objects of class Class_Declaration
     */
    public Class_Declaration(Identifier newIdentifier, List<Declaration_Statement> newInstanceVariables, List<Constructor_Declaration> newConstructors, List<Method_Declaration> newMethods, SymbolTable parent) throws Exception
    {
        identifier = newIdentifier;
        instanceVariables = newInstanceVariables;
        constructors = newConstructors;
        methods = newMethods;
        symTab = new SymbolTable();
        if(parent != null) {
            symTab.setParent(parent);
            parent.addVal(identifier.getIdentifier(), this); 
        }
    }
}
