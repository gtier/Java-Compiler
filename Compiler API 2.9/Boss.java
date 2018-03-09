import java.util.*;
/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss
{
    // instance variables - replace the example below with your own
    SymbolTable symTab, symTab1, symTab2;
    Parser mathParser;
    Numerical_Expression mathExpression;
    /**
     * Constructor for objects of class Boss
     */
    public Boss()
    {
        // initialise instance variables
        symTab = new SymbolTable();
        symTab1 = new SymbolTable();
        symTab2 = new SymbolTable();
        mathParser = new Parser();
    }
    
    public void setup() throws Exception {
        mathParser.setString("4*(8-(2*2))");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("Test 1");
        System.out.println(mathExpression.toString());
        System.out.println(mathExpression.evaluate(symTab));
        System.out.println(" ");
        
        mathParser.setString("w*x/z");
        symTab.addVal("x", "4");
        symTab.addVal("w", "10");
        symTab.addVal("z", "5");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("Test 2");
        System.out.println(symTab.toString());
        System.out.println(mathExpression.toString());
        System.out.println(mathExpression.evaluate(symTab));
        System.out.println(" ");
        
        symTab1.setParent(symTab);
        symTab2.setParent(symTab1);
        
        mathParser.setString("y*x");
        symTab1.addVal("y", "4");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("Test 3");
        System.out.println("SymTab: " + symTab.toString());
        System.out.println("SymTab1: " + symTab1.toString());
        System.out.println("SymTab2: " + symTab2.toString());
        System.out.println(mathExpression.toString());
        System.out.println(mathExpression.evaluate(symTab2));
        System.out.println(" ");
        
        mathParser.setString("x*(x-y)");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("Test 4");
        System.out.println("SymTab: " + symTab.toString());
        System.out.println("SymTab1: " + symTab1.toString());
        System.out.println("SymTab2: " + symTab2.toString());
        System.out.println(mathExpression.toString());
        System.out.println(mathExpression.evaluate(symTab2));
        System.out.println(" ");
        
        Double zero = (-1.0);
        Boolean_Expression boolExp = new Boolean_Expression("!=", mathExpression, new Numerical_Expression(zero));
        Print_Statement success = new Print_Statement("Success");
        Print_Statement failure = new Print_Statement("Failure");
        If_Statement testIf1 = new If_Statement(boolExp, success, failure, null);
        If_Statement testIf = new If_Statement(boolExp, testIf1, failure, symTab2);
        testIf.run();
        
        symTab2.addVal("i", new Double(1.0));
        symTab.addVal("fi", null);
        symTab1.addVal("w", new Double(1.0));
        For_Statement testFor;
        mathParser.setString("i+1");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        Assignment_Statement assign = new Assignment_Statement("i", mathExpression, symTab2);
        mathParser.setString("2");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        Assignment_Statement w = new Assignment_Statement("w", mathExpression, symTab2);
        mathParser.setString("i^w");
        try {
            mathExpression = mathParser.parseNumericalExpression();
        } catch (Exception e) {
            throw new Exception(e);
        }
        Assignment_Statement fi = new Assignment_Statement("fi", mathExpression, symTab2);
        Print_Statement message = new Print_Statement("fi", symTab2);
        
        Declaration_Statement i = new Declaration_Statement("i", new Numerical_Expression(new Double(0.0)), null);
        Boolean_Expression boolExpression = new Boolean_Expression("<", new Numerical_Expression("i"), new Numerical_Expression(new Double(10.0)));
        Assignment_Statement toDo = new Assignment_Statement("i", new Numerical_Expression("+", new Numerical_Expression("i"), new Numerical_Expression(new Double(1.0))), null);
        List<Declaration_Statement> iList = new ArrayList();
        iList.add(i);
        List<Assignment_Statement> toDoList = new ArrayList();
        toDoList.add(toDo);
        //To print as variable use null or symbol table after name
        Print_Statement toPrint = new Print_Statement("i", null);
        
        Boolean_Expression lessThan5 = new Boolean_Expression("<", new Numerical_Expression("i"), new Numerical_Expression(new Double(5.0)));
        Print_Statement toPrint1 = new Print_Statement("i is less than 5: ");
        Print_Statement toPrint2 = new Print_Statement("i", null);
        List<Statement> printList = new ArrayList();
        printList.add(toPrint1);
        printList.add(toPrint2);
        
        Print_Statement Print1 = new Print_Statement("i is greater than or equal to 5: ");
        Print_Statement Print2 = new Print_Statement("....");
        List<Statement> falsePrint = new ArrayList();
        falsePrint.add(Print1);
        falsePrint.add(Print2);
        
        StatementList printIfTrue = new StatementList(printList);
        StatementList printIfFalse = new StatementList(falsePrint);
        If_Statement myIf = new If_Statement(lessThan5, printIfTrue, printIfFalse, null);
        
        
        
        For_Statement myFor = new For_Statement(iList, boolExpression, toDoList, myIf, null);
        myFor.run();
        
        System.out.println("Testing assignment with expression");
        SymbolTable boolTable = new SymbolTable();
        boolTable.addVal("x", new Boolean_Expression("==", new Numerical_Expression(new Double(1.0)), new Numerical_Expression(new Double(1.0))));
        Boolean_Expression testBoolVar = new Boolean_Expression("==", new Boolean_Expression("x"), new Boolean_Expression("==", new Numerical_Expression(new Double(1.0)), new Numerical_Expression(new Double(1.0))));
        System.out.println(testBoolVar.evaluate(boolTable).toString());
    }
}
