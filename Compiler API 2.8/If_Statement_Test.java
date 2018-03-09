

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class If_StatementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class If_Statement_Test
{
    /**
     * Default constructor for test class If_StatementTest
     */
    public If_Statement_Test()
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
            Double result;
            Declaration_Statement declareX = new Declaration_Statement("x", new Numerical_Expression(new Double(0.0)), mainTab);
            Assignment_Statement addX = new Assignment_Statement("x", new Numerical_Expression(new Double(1.0)), null);
            Assignment_Statement subtractX = new Assignment_Statement("x", new Numerical_Expression(new Double(-1.0)), null);
            Boolean_Expression trueBoolExp = new Boolean_Expression("==", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0)));
            Boolean_Expression falseBoolExp = new Boolean_Expression("!=", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0)));
            If_Statement trueIfStatement = new If_Statement(trueBoolExp, addX, subtractX, mainTab);
            If_Statement falseIfStatement = new If_Statement(falseBoolExp, addX, subtractX, mainTab);
            
            declareX.run();
            
            trueIfStatement.run();
            result = (Double)mainTab.getVal("x").getValue();
            assertNotNull(result);
            assertEquals(1.0, result, 0.1);
            
            falseIfStatement.run();
            result = (Double)mainTab.getVal("x").getValue();
            assertNotNull(result);
            assertEquals(-1.0, result, 0.1); 
        } catch (Exception e) {
            fail("Error in If_Statement_Test.run: " + e); 
        }
    }
}

