
/**
 * Write a description of class Primitive_Holder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Primitive_Container
{
    // instance variables - replace the example below with your own
    private double doubleVal;
    private float floatVal;
    private int intVal;
    private boolean booleanVal;

    /**
     * Constructor for objects of class Primitive_Holder
     */
    public Primitive_Container()
    {
        // initialise instance variables
        
    }
    
    public void setDouble(double newDoubleVal) {
        doubleVal = newDoubleVal;
    }
    
    public void setFloat(float newFloatVal) {
        floatVal = newFloatVal;
    }
    
    public void setInt(int newIntVal) {
        intVal = newIntVal;
    }
    
    public void setBoolean(boolean newBooleanVal) {
        booleanVal = newBooleanVal;
    }
    
    public double getDouble() {
        return doubleVal;
    }
    
    public float getFloat() {
        return floatVal;
    }
    
    public int getInt() {
        return intVal;
    }
    
    public boolean getBoolean() {
        return booleanVal;
    }
    
}
