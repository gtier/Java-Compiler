import java.util.*;
/**
 * Write a description of class Indentifier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Identifier
{
    // instance variables - replace the example below with your own
    private String identifier;
    private String charSpace;

    /**
     * Constructor for objects of class Indentifier
     */
    public Identifier(String newIdentifier) throws Exception
    {
        // initialise instance variables
        charSpace = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        identifier = checkIfValid(newIdentifier);
    }
    
    private String checkIfValid(String str) throws Exception {
        for(int i = 0; i<str.length(); i++) {
            int inSet = 0;
            for(int x = 0; x<charSpace.length(); x++) {
                if (str.charAt(i) == charSpace.charAt(x)) {
                    inSet = 1;
                }
            }
            if (inSet == 0) {
                throw new Exception("Error in Indentifier checkIfValid: " + str + " is a reserved character");
            }
            inSet = 0;
        }
        
        return str;
    }
    
    public String getIdentifier() {
        return identifier;
    }
}
