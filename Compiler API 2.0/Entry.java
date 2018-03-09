
/**
 * Write a description of class Entry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entry
{
    // instance variables - replace the example below with your own
    private String name;
    private Object value;

    /**
     * Constructor for objects of class Entry
     */
    public Entry(String newName, Object newValue)
    {
        // initialise instance variables
        name = newName;
        value = newValue;
    }
   
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    public String setName(String newName)
    {
        name = newName;
        return name;
    }

    public Object getValue()
    {
        // put your code here
        return value;
    }
    
    public Object setValue(Object newValue)
    {
        value = newValue;
        return value;
    }

    public String toString()
    {
        return "Name: " + name + ", " + "Value: " + value.toString();
    }
}
