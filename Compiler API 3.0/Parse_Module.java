
/**
 * Abstract class Parse_Module - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class Parse_Module
{
    // instance variables - replace the example below with your own
    private String string;
    
    public Parse_Module(String newString){
        string = newString;
    }
    
    public Parse_Module(){
        
    }
    
    public Numerical_Expression parseNumExp(String newString) throws Exception {
        Parse_Num_Exp_Module parseNumExpModule = new Parse_Num_Exp_Module(newString);
        return parseNumExpModule.parse();
    }
    
    public Boolean_Expression parseBoolExp(String newString) throws Exception {
        Parse_Bool_Exp_Module parseBoolExpModule = new Parse_Bool_Exp_Module(newString);
        return parseBoolExpModule.parse();
    }
    
    public void setString(String newString) {
        string = newString;
    }
}
