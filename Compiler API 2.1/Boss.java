
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
        
        mathParser.setString("4*x");
        symTab.addVal("x", "4");
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
        If_Statement testIf = new If_Statement(boolExp, success, failure, symTab2);
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
        StatementList list = new StatementList();
        list.add(w);
        list.add(fi);
        list.add(message);
        list.add(assign);
        int iterator = 0;
        Statement statement = message;
        String operator = "<";
        int boundry = 5;
        String increment = "++";
        testFor = new For_Statement(iterator, operator, boundry, increment, list, symTab2);
        testFor.run();
    }
}
