import java.util.*;
/**
 * Write a description of class Parameter_List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parameter_List
{
    // instance variables - replace the example below with your own
    private List<Parameter> parameterList;

    /**
     * Constructor for objects of class Parameter_List
     */
    
    public Parameter_List()
    {
        // initialise instance variables
        parameterList = new ArrayList<Parameter>();
    }
    
    public Parameter_List(List<Parameter> newParameterList)
    {
        // initialise instance variables
        parameterList = newParameterList;
    }
    
    public void add(Parameter parameter) {
        parameterList.add(parameter);
    }
    
    public int size() {
        return parameterList.size();
    }
    
    public Parameter get(int i) {
        return parameterList.get(i);
    }

}
