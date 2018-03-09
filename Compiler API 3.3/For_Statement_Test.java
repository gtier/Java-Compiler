

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class For_StatementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class For_Statement_Test
{
    /**
     * Default constructor for test class For_StatementTest
     */
    public For_Statement_Test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void run()
    {
        try {
        SymbolTable mainTab = new SymbolTable();
        Declaration_Statement declareX = new Declaration_Statement("x", new Numerical_Expression(new Double(0.0)), mainTab);
        
        Declaration_Statement i = new Declaration_Statement("i", new Numerical_Expression(new Double(0.0)), null);
        Boolean_Expression boolExpression = new Boolean_Expression("<", new Numerical_Expression("i"), new Numerical_Expression(new Double(10.0)));
        Assignment_Statement toDo = new Assignment_Statement("i", new Numerical_Expression("+", new Numerical_Expression("i"), new Numerical_Expression(new Double(1.0))), null);
        Assignment_Statement addOneToX = new Assignment_Statement("x", new Numerical_Expression("+", new Numerical_Expression("x"), new Numerical_Expression(new Double(1.0))), null);
        List<Declaration_Statement> iList = new ArrayList();
        iList.add(i);
        List<Assignment_Statement> toDoList = new ArrayList();
        toDoList.add(toDo);
        toDoList.add(addOneToX);
        //To print as variable use null or symbol table after name
        
        Boolean_Expression lessThan5 = new Boolean_Expression("<", new Numerical_Expression("i"), new Numerical_Expression(new Double(5.0)));
        Print_Statement toPrintTrueInfo = new Print_Statement("i < 5: ");
        Print_Statement toPrintTrueI = new Print_Statement("i", null);
        List<Statement> printList = new ArrayList();
        printList.add(toPrintTrueInfo);
        printList.add(toPrintTrueI);
        
        Print_Statement toPrintFalseInfo = new Print_Statement("i >= 5: ");
        Print_Statement toPrintFalseI = new Print_Statement("i", null);
        List<Statement> falsePrint = new ArrayList();
        falsePrint.add(toPrintFalseInfo);
        falsePrint.add(toPrintFalseI);
        
        StatementList printIfTrue = new StatementList(printList);
        StatementList printIfFalse = new StatementList(falsePrint);
        If_Statement myIf = new If_Statement(lessThan5, printIfTrue, printIfFalse, null);
        
        For_Statement myFor = new For_Statement(iList, boolExpression, toDoList, myIf, mainTab);
        declareX.run();
        myFor.run();
        
        Double result;
        result = (Double)mainTab.getVal("x").getValue();
        assertNotNull(result);
        assertEquals(10.0, result, 0.1); 
    } catch (Exception e) {
        fail("Error in For_Statement_Test.run: " + e);
    }
    }
}

