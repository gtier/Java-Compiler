
/**
 * Abstract class Loop_Statement - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Loop_Statement extends Statement
{
    // instance variables - replace the example below with your own
    public abstract void run() throws Exception;
    public abstract SymbolTable getSymTab();
    public abstract void setParent(SymbolTable newParent);
    public abstract String toString();
    public abstract void stop();
}
