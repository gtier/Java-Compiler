
/**
 * Write a description of class Expression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Expression
{
    // instance variables - replace the example below with your own
    public Object evaluate(SymbolTable symTab) throws Exception;
    
    public String toString();
}
