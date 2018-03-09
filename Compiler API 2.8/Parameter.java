
/**
 * Write a description of class Parameter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parameter
{
    // instance variables - replace the example below with your own
    Type type;
    Identifier identifier;

    /**
     * Constructor for objects of class Parameter
     */
    public Parameter(Type newType, Identifier newIdentifier)
    {
        // initialise instance variables
        type = newType;
        identifier = newIdentifier;
    }
    
    public Type getType() {
        return type;
    }
    
    public Identifier getIdentifier() {
        return identifier;
    }
}
