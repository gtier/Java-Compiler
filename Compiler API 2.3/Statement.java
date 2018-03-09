
/**
 * Write a description of class Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Statement
{
    // instance variables - replace the example below with your own
    public SymbolTable run(SymbolTable newSymTab) throws Exception;
    
    public String toString();
}
