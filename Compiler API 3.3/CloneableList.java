import java.util.*;
/**
 * Write a description of class CloneableList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CloneableList implements Cloneable
{
    // instance variables - replace the example below with your own
    private List<Object> list;
    /**
     * Constructor for objects of class CloneableList
     */
    public CloneableList(List<Object> newList) throws Exception
    {
        if (newList != null) {
            list = newList;
        } else {
            throw new Exception("List cannot be null");
        }
    }
    
    public List<Object> getList() {
        return list;
    }

}
