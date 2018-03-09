

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SymbolTableTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SymbolTableTest
{
    /**
     * Default constructor for test class SymbolTableTest
     */
    public SymbolTableTest()
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
    public void addValTest()
    {
        SymbolTable testTable = new SymbolTable();
        Entry entry1 = null;
        try {
            entry1 = testTable.addVal("testObject", 42);
            assertNotNull(entry1);
            assertEquals("testObject", entry1.getName());
            java.lang.Integer object1 = (java.lang.Integer)entry1.getValue();
            assertNotNull(object1);
            assertEquals(42, object1.intValue());
        
        } catch( Exception e) {
            System.out.println("Big Trouble in addValTest: " + e);
            // ?? return ?? assert??
            assertNotNull( e );
        }
        
        try {
            entry1 = testTable.addVal("testObject", 24);   // duplicate with new val
            assertNotNull(entry1);
            assertEquals("testObject", entry1.getName());
            java.lang.Integer object1 = (java.lang.Integer)entry1.getValue();
            assertNotNull(object1);
            assertEquals(42, object1.intValue());
        
        } catch( Exception e) {
            System.out.println("Error in addValTest add another testObject: " + e);
            
            assertNotNull( e );
        }
        
        try {
            assertNotNull(testTable.addVal(null, 42));
            
        } catch( Exception e) {
            System.out.println("Error in addValTest add null name: " + e);
        }
        
        try {
            assertNotNull(testTable.addVal("testNullValue", null));
            
        } catch( Exception e) {
            System.out.println("Error in addValTest add null value: " + e);
        }
    }

    @Test
    public void getValTest()
    {
        try {
            SymbolTable symbolTa1 = new SymbolTable();
            Entry entry1 = symbolTa1.addVal("test", "1");
            assertNotNull(entry1);
            assertEquals("test", entry1.getName());
            assertEquals("1", entry1.getValue());
            Entry getEntry1 = symbolTa1.getVal("test");
            assertNotNull(getEntry1);
            assertEquals("test", getEntry1.getName());
            assertEquals("1", getEntry1.getValue());
            assertNull(symbolTa1.getVal("random"));
        } catch (Exception e) {
            System.out.println("Error in getValTest: " + e);
        }
    }
}


