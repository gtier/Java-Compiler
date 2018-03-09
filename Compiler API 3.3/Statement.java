
/**
 * Write a description of class Statement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Statement
{
    // instance variables - replace the example below with your own
    public abstract void run() throws Exception;
    public abstract SymbolTable getSymTab();
    public abstract void setParent(SymbolTable newParent);
    public abstract String toString();
    public abstract Statement getParentStatement();
    public abstract void setParentStatement(Statement newParentStatement);
    public abstract void setParentMethod(Method_Declaration newParentMethod);
    public abstract Method_Declaration getParentMethod();
    public abstract void execReturn();
}
