

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Boolean_ExpressionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Boolean_Expression_Test
{
    /**
     * Default constructor for test class Boolean_ExpressionTest
     */
    public Boolean_Expression_Test()
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
    public void evaluate() throws Exception
    {
        try {
        Boolean_Expression boolean_1 = new Boolean_Expression("==", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0)));
        java.lang.Boolean boolean1 = boolean_1.evaluate(null);
        assertNotNull(boolean1);
        assertEquals(true, boolean1.booleanValue());
        Boolean_Expression boolean_2 = new Boolean_Expression(">", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0)));
        java.lang.Boolean boolean2 = boolean_2.evaluate(null);
        assertNotNull(boolean2);
        assertEquals(true, boolean2.booleanValue());
        Boolean_Expression boolean_3 = new Boolean_Expression("<", new Numerical_Expression(new Double(0.0)), new Numerical_Expression(new Double(2.0)));
        java.lang.Boolean boolean3 = boolean_3.evaluate(null);
        assertNotNull(boolean3);
        assertEquals(true, boolean3.booleanValue());
        Boolean_Expression boolean_4 = new Boolean_Expression("!=", new Numerical_Expression(new Double(1.0)), new Numerical_Expression(new Double(2.0)));
        java.lang.Boolean boolean4 = boolean_4.evaluate(null);
        assertNotNull(boolean4);
        assertEquals(true, boolean4.booleanValue());
        Boolean_Expression boolean_5 = new Boolean_Expression("==", new Boolean_Expression("==", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0))), new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))));
        java.lang.Boolean boolean5 = boolean_5.evaluate(null);
        assertNotNull(boolean5);
        assertEquals(true, boolean5.booleanValue());
        Boolean_Expression boolean_6 = new Boolean_Expression("!=", new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))), new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))));
        assertNotNull(boolean_6.evaluate(null));
        java.lang.Boolean boolean6 = boolean_6.evaluate(null);
        assertNotNull(boolean6);
        assertEquals(false, boolean6.booleanValue());
        Boolean_Expression boolean_7 = new Boolean_Expression("!=", new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))), new Boolean_Expression("==", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))));
        java.lang.Boolean boolean7 = boolean_7.evaluate(null);
        assertNotNull(boolean7);
        java.lang.Boolean boolean8 = boolean_7.evaluate(null);
        assertNotNull(boolean8);
        assertEquals(true, boolean8.booleanValue());
        Boolean_Expression boolean_8 = new Boolean_Expression("==", new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))), new Boolean_Expression("==", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))));
        java.lang.Boolean boolean9 = boolean_8.evaluate(null);
        assertNotNull(boolean9);
        assertEquals(false, boolean9.booleanValue());
        Boolean_Expression boolean_9 = new Boolean_Expression("==", new Boolean_Expression("!=", new Numerical_Expression(new Double(3.0)), new Numerical_Expression(new Double(2.0))), new Boolean_Expression("==", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0))));
        java.lang.Boolean boolean10 = boolean_9.evaluate(null);
        assertNotNull(boolean10);
        assertEquals(true, boolean10.booleanValue());
        
        SymbolTable boolTab = new SymbolTable();
        SymbolTable subTab = new SymbolTable();
        subTab.setParent(boolTab);
        boolTab.addVal("x", new Boolean_Expression("==", new Numerical_Expression(new Double(2.0)), new Numerical_Expression(new Double(2.0))));
        assertNotNull(boolTab.getVal("x").getValue());
        Boolean_Expression boolExp = (Boolean_Expression)boolTab.getVal("x").getValue();
        assertNotNull(boolExp);
        assertEquals(true, boolExp.evaluate(null));
        Boolean_Expression constantBool = new Boolean_Expression("==", new Numerical_Expression(new Double(1.0)), new Numerical_Expression(new Double(0.0)));
        Boolean_Expression compareVarToConstant = new Boolean_Expression("!=", new Boolean_Expression("x"), constantBool);
        assertNotNull(compareVarToConstant);
        assertEquals(true, compareVarToConstant.evaluate(subTab));
    } catch (Exception e) {
        fail("Error in Boolean_Expression_Test evaluate: " + e);
    }
    }
}

