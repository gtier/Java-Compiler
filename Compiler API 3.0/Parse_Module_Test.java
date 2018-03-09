

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Parse_ModuleTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Parse_Module_Test
{
    /**
     * Default constructor for test class Parse_ModuleTest
     */
    public Parse_Module_Test()
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
    public void parseNumExp()
    {
        try {
            Parse_Module parser1 = new Parse_Module();
            parser1.setString("4*(5-1)");
            Numerical_Expression numerica1 = parser1.parseNumExp("4*(5-1)");
            assertNotNull(numerica1);
            assertEquals("(4.0*(5.0-1.0))", numerica1.toString());
            java.lang.Double double1 = numerica1.evaluate(null);
            assertNotNull(double1);
            assertEquals(16, double1.doubleValue(), 0.1);
            parser1.setString("(3/2*16-4)/5");
            Numerical_Expression numerica2 = parser1.parseNumExp("(3/2*16-4)/5");
            assertNotNull(numerica2);
            assertEquals("((((3.0/2.0)*16.0)-4.0)/5.0)", numerica2.toString());
            java.lang.Double double2 = numerica2.evaluate(null);
            assertNotNull(double2);
            assertEquals(4.0, double2.doubleValue(), 0.1);
        } catch (Exception e) {
            fail("Error in parseNumericalExpressionTest: " + e);
        }
    }
}

