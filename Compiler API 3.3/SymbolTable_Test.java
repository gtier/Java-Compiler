

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
public class SymbolTable_Test
{
    /**
     * Default constructor for test class SymbolTableTest
     */
    public SymbolTable_Test()
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
    public void addVal()
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
            fail("Big Trouble in addValTest: " + e);
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
            
            assertNotNull( e );
        }
        
        try {
            assertNotNull(testTable.addVal("testNullValue", null));
            
        } catch( Exception e) {
            fail("Error in addValTest add null value: " + e);
        }
    }

    @Test
    public void getVal()
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
        } catch (Exception e) {
            fail("Error in getValTest: " + e);
        }
    }

    @Test
    public void updateVal()
    {
        try {
            SymbolTable symbolTa1 = new SymbolTable();
            Entry entry1 = symbolTa1.addVal("x", "0");
            assertNotNull(entry1);
            assertEquals("x", entry1.getName());
            assertEquals("0", entry1.getValue());
            assertNotNull(symbolTa1.updateVal("x", "2"));
            Entry entry2 = symbolTa1.getVal("x");
            assertNotNull(entry2);
            assertEquals("x", entry2.getName());
            assertEquals("2", entry2.getValue());
            SymbolTable parent = new SymbolTable();
            Entry parEntry = parent.addVal("p", "4");
            assertNotNull(parEntry);
            assertEquals("p", parEntry.getName());
            assertEquals("4", parEntry.getValue());
            symbolTa1.setParent(parent);
            assertNotNull(symbolTa1.updateVal("p", "2"));
            Entry updatedParEntry = parent.getVal("p");
            assertNotNull(updatedParEntry);
            assertEquals("p", updatedParEntry.getName());
            assertEquals("2", updatedParEntry.getValue());
        } catch (Exception e) {
            fail("Error in updateVal: " + e);
        }
    }
}



