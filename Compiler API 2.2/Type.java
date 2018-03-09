
/**
 * Write a description of class Type here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Type
{
    // instance variables - replace the example below with your own
    private Class type;

    /**
     * Constructor for objects of class Type
     */
    public Type(String newType) throws Exception
    {
        // initialise instance variables
        switch(newType) {
            case "boolean":
                type = Boolean.class;
                break;
            case "byte":
                type = Byte.class;
                break;
            case "short":
                type = Short.class;
                break;
            case "int":
                type = Integer.class;
                break;
            case "float":
                type = Float.class;
                break;
            case "long":
                type = Long.class;
                break;
            case "double":
                type = Double.class;
                break;
            default:
                throw new Exception("Error in Type: " + newType + " is not a valid type");
        }
    }
    
    public Class getType() {
        return type;
    }
}
