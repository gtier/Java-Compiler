
/**
 * Write a description of class Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Statement
{
    // instance variables - replace the example below with your own
    public void run() throws Exception;
    public SymbolTable getSymTab();
    public void setParent(SymbolTable newParent);
    public String toString();
}
