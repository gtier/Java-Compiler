

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class While_StatementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class While_Statement_Test
{
    /**
     * Default constructor for test class While_StatementTest
     */
    public While_Statement_Test()
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
        
        Boolean_Expression boolExpression = new Boolean_Expression("<", new Numerical_Expression("x"), new Numerical_Expression(new Double(25.0)));
        Assignment_Statement addOneToX = new Assignment_Statement("x", new Numerical_Expression("+", new Numerical_Expression("x"), new Numerical_Expression(new Double(1.0))), null);
        StatementList toDoList = new StatementList();
        toDoList.add(addOneToX);
        //To print as variable use null or symbol table after name
        While_Statement myWhile = new While_Statement(boolExpression, toDoList, mainTab);
        declareX.run();
        myWhile.run();
        
        Double result;
        result = (Double)mainTab.getVal("x").getValue();
        assertNotNull(result);
        assertEquals(25.0, result, 0.1); 
    } catch (Exception e) {
        fail("Error in For_Statement_Test.run: " + e);
    }
    }
}

