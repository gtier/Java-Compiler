

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class Method_DeclarationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Method_Declaration_Test
{
    /**
     * Default constructor for test class Method_DeclarationTest
     */
    public Method_Declaration_Test()
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
    public void construction_and_return()
    {
        try {
            SymbolTable symTab = new SymbolTable();
            Type funcType = new Type("double");
            Identifier funcName = new Identifier("square");
            Parameter_List parameters = new Parameter_List();
            Type numType = new Type("double");
            Identifier numName = new Identifier("x");
            Parameter parameter = new Parameter(numType, numName);
            parameters.add(parameter);
            StatementList statements = new StatementList();
            Return_Statement funcReturn = new Return_Statement(new Numerical_Expression("^", new Numerical_Expression("x"), new Numerical_Expression(new Double(2.0))));
            Method_Declaration func = new Method_Declaration(funcType, funcName, parameters, funcReturn, symTab);
            symTab.addVal("toReturn", new Double(2.0));
            System.out.println(symTab.toString());
            List<Object> list = new ArrayList();
            list.add(symTab.getVal("toReturn").getValue());
            func.call(list, "toReturn", symTab);
            System.out.println(symTab.toString());
            assertEquals(4.0, symTab.getVal("toReturn").getValue());
            
            list.clear();
            list.add(symTab.getVal("toReturn").getValue());
            func.call(list, "toReturn", symTab);
            System.out.println(symTab.toString());
            assertEquals(16.0, symTab.getVal("toReturn").getValue());
            
            list.clear();
            list.add(symTab.getVal("toReturn").getValue());
            func.call(list, "toReturn", symTab);
            System.out.println(symTab.toString());
            assertEquals(256.0, symTab.getVal("toReturn").getValue());
            
            list.clear();
            list.add(symTab.getVal("toReturn").getValue());
            func.call(list, "toReturn", symTab);
            System.out.println(symTab.toString());
            assertEquals(65536.0, symTab.getVal("toReturn").getValue());
        } catch (Exception e) {
            fail("Error in Method_Declaration_Test: " + e);
        }
    }
}

