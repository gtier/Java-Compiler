

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Numerical_ExpressionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Numerical_Expression_Test
{
    /**
     * Default constructor for test class Numerical_ExpressionTest
     */
    public Numerical_Expression_Test()
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
    public void evaluate()
    {
        try {
            Numerical_Expression numerica1 = new Numerical_Expression(new Double(10.0));
            java.lang.Double double1 = numerica1.evaluate(null);
            assertNotNull(double1);
            assertEquals(10.0, double1.doubleValue(), 0.1);
            Numerical_Expression numerica2 = new Numerical_Expression("+", new Numerical_Expression(new Double(32)), new Numerical_Expression(new Double(10)));
            java.lang.Double double2 = numerica2.evaluate(null);
            assertNotNull(double2);
            assertEquals(42.0, double2.doubleValue(), 0.1);
            Numerical_Expression numerica3 = new Numerical_Expression("-", new Numerical_Expression(new Double(50.0)), new Numerical_Expression(new Double(8.0)));
            assertNotNull(numerica3.evaluate(null));
            java.lang.Double double3 = numerica3.evaluate(null);
            assertNotNull(double3);
            assertEquals(42.0, double3.doubleValue(), 0.1);
            Numerical_Expression numerica4 = new Numerical_Expression("*", new Numerical_Expression(new Double(4.2)), new Numerical_Expression(new Double(10)));
            java.lang.Double double4 = numerica4.evaluate(null);
            assertNotNull(double4);
            assertEquals(42.0, double4.doubleValue(), 0.1);
            Numerical_Expression numerica5 = new Numerical_Expression("/", new Numerical_Expression(new Double(81.0)), new Numerical_Expression(new Double(9.0)));
            java.lang.Double double5 = numerica5.evaluate(null);
            assertNotNull(double5);
            assertEquals(9.0, double5.doubleValue(), 0.1);
            Numerical_Expression numerica6 = new Numerical_Expression("^", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(4.0)));
            java.lang.Double double6 = numerica6.evaluate(null);
            assertNotNull(double6);
            assertEquals(16.0, double6.doubleValue(), 0.1);
            
            SymbolTable mathTab = new SymbolTable();
            SymbolTable parent = new SymbolTable();
            SymbolTable grandParent = new SymbolTable();
            mathTab.setParent(parent);
            parent.setParent(grandParent);
            grandParent.addVal("w", "8");
            mathTab.addVal("x", "4");
            mathTab.addVal("y", "16");
            Parser mathParser = new Parser();
            
            mathParser.setString("x*4");
            Numerical_Expression mathOutput;
            Double doubleOut;
            mathOutput = mathParser.parseNumericalExpression();
            doubleOut = mathOutput.evaluate(mathTab);
            assertNotNull(doubleOut);
            assertEquals(16.0, doubleOut.doubleValue(), 0.1);
            mathParser.setString("x*y");
            mathOutput = mathParser.parseNumericalExpression();
            doubleOut = mathOutput.evaluate(mathTab);
            assertNotNull(doubleOut);
            assertEquals(64.0, doubleOut.doubleValue(), 0.1);
            
            mathParser.setString("x*y/w");
            mathOutput = mathParser.parseNumericalExpression();
            doubleOut = mathOutput.evaluate(mathTab);
            assertNotNull(doubleOut);
            assertEquals(8.0, doubleOut.doubleValue(), 0.1);
            
        } catch (Exception e) {
            fail("Error in Numerical_Expression_Test: " + e);
        }
    }
}


