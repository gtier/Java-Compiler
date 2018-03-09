
/**
 * Write a description of class For_Statement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class For_Statement extends Statement
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
    
    public void run() throws Exception {
        if (increment.equals("++")) {
            switch (operator) {
                case "=":
                    for(int i = iterator; i == boundry; i++) {
                        statement.run();
                    }
                    break;
                case "!=":
                    for(int i = iterator; i != boundry; i++) {
                        statement.run();
                    }
                    break;
                case "<":
                    for(int i = iterator; i < boundry; i++) {
                       statement.run();
                    }
                    break;
                case "<=":
                    for(int i = iterator; i <= boundry; i++) {
                        statement.run();
                    }
                    break;
            }
        } else if (increment.equals("--")) {
            switch (operator) {
                case "=":
                    for(int i = iterator; i == boundry; i--) {
                        statement.run();
                    }
                    break;
                case "!=":
                    for(int i = iterator; i != boundry; i--) {
                        statement.run();
                    }
                    break;
                case ">":
                    for(int i = iterator; i > boundry; i--) {
                        statement.run();
                    }
                    break;
                case ">=":
                    for(int i = iterator; i >= boundry; i--) {
                        statement.run();
                    }
                    break;
            }
        }
    }
}
