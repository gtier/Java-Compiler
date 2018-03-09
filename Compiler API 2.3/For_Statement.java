
/**
 * Write a description of class For_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class For_Statement implements Statement
{
    // instance variables - replace the example below with your own
    int iterator;
    Statement statement;
    SymbolTable symTab;
    String operator;
    int boundry;
    String increment;
    /**
     * Constructor for objects of class For_Statement
     */
    public For_Statement(Integer newIterator, String newOperator, Integer newBoundry, String newIncrement, Statement newStatement, SymbolTable newSymTab)
    {
        // initialise instance variables
        iterator = newIterator.intValue();
        statement = newStatement;
        symTab = newSymTab;
        operator = newOperator;
        boundry = newBoundry;
        increment = newIncrement;
    }
    
    public For_Statement(int newIterator, String newOperator, int newBoundry, String newIncrement,  Statement newStatement, SymbolTable newSymTab)
    {
        // initialise instance variables
        iterator = newIterator;
        statement = newStatement;
        symTab = newSymTab;
        operator = newOperator;
        boundry = newBoundry;
        increment = newIncrement;
    }
    
    public SymbolTable run(SymbolTable newSymTab) throws Exception {
        if (newSymTab != null) {
            symTab = newSymTab;
        }
        if (increment.equals("++")) {
            switch (operator) {
                case "=":
                    for(int i = iterator; i == boundry; i++) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
                case "!=":
                    for(int i = iterator; i != boundry; i++) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
                case "<":
                    for(int i = iterator; i < boundry; i++) {
                       newSymTab = statement.run(newSymTab);
                    }
                    break;
                case "<=":
                    for(int i = iterator; i <= boundry; i++) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
            }
        } else if (increment.equals("--")) {
            switch (operator) {
                case "=":
                    for(int i = iterator; i == boundry; i--) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
                case "!=":
                    for(int i = iterator; i != boundry; i--) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
                case ">":
                    for(int i = iterator; i > boundry; i--) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
                case ">=":
                    for(int i = iterator; i >= boundry; i--) {
                        newSymTab = statement.run(newSymTab);
                    }
                    break;
            }
        }
        return newSymTab;
    }
    
    public String toString() {
        return "for(int i = " + iterator + "; i " + operator + " " + boundry + "; i" + increment + ") {" + System.getProperty("line.separator") + System.getProperty("line.separator") + statement.toString().replaceAll("(?m)^", "    ") + System.getProperty("line.separator") + "}";
    }
}
