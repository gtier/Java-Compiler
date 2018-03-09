import java.util.*;
/**
 * Write a description of class Call_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Call_Statement extends Statement
{
    // instance variables - replace the example below with your own
    List<Expression> expressions;
    List<Object> objectList;
    SymbolTable symTab;
    Statement parentStatement;
    Method_Declaration parentMethod;
    String toUpdate;
    String methodName;
    Method_Declaration methodToCall;
    
    /**
     * Constructor for objects of class Call_Statement
     */
    public Call_Statement(List<Expression> newExpressions, String newMethodName, String newToUpdate)
    {
        // initialise instance variables
        expressions = newExpressions;
        objectList = new ArrayList();
        symTab = new SymbolTable();
        toUpdate = newToUpdate;
        methodName = newMethodName;
    }
    
    public SymbolTable getSymTab() {
        return symTab;
    }
    
    public void setParent(SymbolTable newParent) {
        symTab.setParent(newParent);
    }
    
    public void setParentStatement(Statement newParentStatement) {
        parentStatement = newParentStatement;
    }
    
    public Statement getParentStatement() {
        return parentStatement;
    }
    
    public void setParentMethod(Method_Declaration newParentMethod) {
        parentMethod = newParentMethod;
    }
    
    public Method_Declaration getParentMethod() {
        return parentMethod;
    }
    
    public void run() throws Exception {
        for (int i = 0; i < expressions.size(); i++) {
            objectList.add(expressions.get(i).evaluate(symTab));
        }
        methodToCall = (Method_Declaration)symTab.getVal(methodName).getValue();
        methodToCall.call(objectList, toUpdate, symTab);
    }
    
    public void execReturn() {
        if (parentStatement != null) {
            parentStatement.execReturn();
        }
    }
    
    public String toString() {
        return "";
    }

}
