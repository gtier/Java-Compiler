import java.util.*;
/**
 * Write a description of class SymbolTable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SymbolTable
{
    // instance variables - replace the example below with your own
    private ArrayList<Entry> symbolTableData = new ArrayList<Entry>();

    /**
     * Constructor for objects of class SymbolTable
     */
    public SymbolTable()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public Entry addVal(String newName, Object newValue) throws Exception, DuplicateEntryException
    {
        // put your code here
        int symbolTableDataLength;
        symbolTableDataLength = symbolTableData.size();
        if(newName == null){
           throw new Exception("Error in addVal: the name you entered is null");
        }
        for(int i = 0; i < symbolTableDataLength; i++) {
            if(symbolTableData.get(i) != null) {
                if(symbolTableData.get(i).getName().equals(newName)){
                    throw new DuplicateEntryException("Error in addVal: There is already an Entry named " + newName);
                }
            }
        }
        Entry newEntry;
        newEntry = new Entry(newName, newValue);
        symbolTableData.add(newEntry);
        return newEntry;
    }
    
    public Entry deleteVal(String name) throws Exception
    {
       int symbolTableDataLength;
       Entry entryToReturn;
       symbolTableDataLength = symbolTableData.size();
       if(name == null){
           throw new Exception("Error in deleteVal: the name you entered is null");
        }
       for(int i = 0; i < symbolTableDataLength; i++) {
           if(symbolTableData.get(i) != null) {
               if(symbolTableData.get(i).getName().equals(name)){
                   entryToReturn = symbolTableData.get(i);
                   symbolTableData.remove(i);
                   return entryToReturn;
                }
            }
        }
        
        throw new Exception("Error in deleteVal: There is no Entry named " + name);
    }
    
    public Entry updateVal(String name, Object newValue) throws Exception {
       int symbolTableDataLength;
       symbolTableDataLength = symbolTableData.size();
       if(name == null){
           throw new Exception("Error in deleteVal: the name you entered is null");
       }
       for(int i = 0; i < symbolTableDataLength; i++) {
           if(symbolTableData.get(i) != null) {
               if(symbolTableData.get(i).getName().equals(name)){
                   symbolTableData.get(i).setValue(newValue);
                   return symbolTableData.get(i);
               }
           }
       }
        
        throw new Exception("Error in updateVal: There is no Entry name " + name);
    }
    
    public Entry getVal(String name) throws Exception {
       int symbolTableDataLength;
       symbolTableDataLength = symbolTableData.size();
       if(name == null){
           throw new Exception("Error in deleteVal: the name you entered is null");
        }
       for(int i = 0; i < symbolTableDataLength; i++) {
           if(symbolTableData.get(i) != null) {
               if(symbolTableData.get(i).getName().equals(name)){
                   return symbolTableData.get(i);
               }
           }
       }
        
        throw new Exception("Error in getVal: There is no Entry name " + name);
    }
    
    public String toString() {
       int symbolTableDataLength;
       symbolTableDataLength = symbolTableData.size();
       String toReturn = " ";
       for(int i = 0; i < symbolTableDataLength; i++) {
           if(symbolTableData.get(i) != null) {
               toReturn += symbolTableData.get(i).toString() + System.getProperty("line.separator");
            }
        }
        
        return toReturn;
    }
}

