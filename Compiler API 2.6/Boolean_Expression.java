
/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boolean_Expression implements Expression
{
    // instance variables - replace the example below with your own
    private String operator;
    private Expression leftSide, rightSide;
    private boolean isVariable;
    private String variable;

    /**
     * Constructor for objects of class BooleanExpression
     */
    public Boolean_Expression(String newOperator, Expression newLeftSide, Expression newRightSide)
    {
        // initialise instance variables
        isVariable = false;
        operator = newOperator;
        leftSide = newLeftSide;
        rightSide = newRightSide;
    }
    
    public Boolean_Expression(String newVariable) {
        isVariable = true;
        variable = newVariable;
    }
    
    public Boolean evaluate(SymbolTable symTab) throws Exception {
        Boolean evalBool = null;
        if(isVariable == true) {
            Expression expReturn = (Expression)symTab.getVal(variable).getValue();
            Boolean boolReturn = (Boolean)expReturn.evaluate(symTab);
            return true;
        } else if (isVariable == false) {
        Object left = leftSide.evaluate(symTab);
        Object right = rightSide.evaluate(symTab);
        if(left.getClass().equals(right.getClass())){
            if((left instanceof Expression) && (right instanceof Expression) || (left instanceof String) && (right instanceof String)){
                switch(operator){
                    case "==":
                        evalBool = (left.equals(right));
                        break;
                    case "!=":
                        evalBool = (!left.equals(right));
                        break;
                }
            } else {
                Primitive_Container leftPrimitiveToUse = new Primitive_Container();
                Primitive_Container rightPrimitiveToUse = new Primitive_Container();
                if(left instanceof Double) {
                    Double doubleLeft = (Double)left;
                    double doublePrimLeft = doubleLeft.doubleValue();
                    leftPrimitiveToUse.setDouble(doublePrimLeft);
                    
                    Double doubleRight = (Double)right;
                    double doublePrimRight = doubleRight.doubleValue();
                    rightPrimitiveToUse.setDouble(doublePrimRight);
                } else if (left instanceof Integer) {
                    Integer integerLeft = (Integer)left;
                    int intLeft = integerLeft.intValue();
                    leftPrimitiveToUse.setInt(intLeft);
                    
                    Integer integerRight = (Integer)right;
                    int intRight = integerRight.intValue();
                    rightPrimitiveToUse.setInt(intRight);
                } else if (left instanceof Float) {
                    Float floatLeft = (Float)left;
                    float floatPrimLeft = floatLeft.floatValue();
                    leftPrimitiveToUse.setFloat(floatPrimLeft);
                    
                    Float floatRight = (Float)right;
                    float floatPrimRight = floatRight.floatValue();
                    rightPrimitiveToUse.setFloat(floatPrimRight);
                } else if (left instanceof Boolean) {
                    Boolean booleanLeft = (Boolean)left;
                    boolean booleanPrimLeft = booleanLeft.booleanValue();
                    leftPrimitiveToUse.setBoolean(booleanPrimLeft);
                    
                    Boolean booleanRight = (Boolean)right;
                    boolean booleanPrimRight = booleanRight.booleanValue();
                    rightPrimitiveToUse.setBoolean(booleanPrimRight);
                }
                
                evalBool = comparePrimitives(operator, leftPrimitiveToUse, rightPrimitiveToUse, left.getClass());
            }
        }
    }
        if (evalBool == null) {
            throw new Exception(leftSide.toString() + operator + rightSide.toString() + " is invalid");
        }
        return evalBool;
    }
    
    private Boolean comparePrimitives(String operator, Primitive_Container leftContainer, Primitive_Container rightContainer, Class classToUse) throws Exception {
        Boolean evalBool = null;
        if(classToUse == Double.class) {
            switch(operator){
                    case "==":
                        evalBool = leftContainer.getDouble() == rightContainer.getDouble();
                        break;
                    case "!=":
                        evalBool = leftContainer.getDouble() != rightContainer.getDouble();
                        break;
                    case ">":
                        evalBool = leftContainer.getDouble() > rightContainer.getDouble();
                        break;
                    case ">=":
                        evalBool = leftContainer.getDouble() >= rightContainer.getDouble();
                        break;
                    case "<":
                        evalBool = leftContainer.getDouble() < rightContainer.getDouble();
                        break;
                    case "<=":
                        evalBool = leftContainer.getDouble() <= rightContainer.getDouble();
                        break;
                    }
        } else if (classToUse == Integer.class) {
            switch(operator){
                    case "==":
                        evalBool = leftContainer.getInt() == rightContainer.getInt();
                        break;
                    case "!=":
                        evalBool = leftContainer.getInt() != rightContainer.getInt();
                        break;
                    case ">":
                        evalBool = leftContainer.getInt() > rightContainer.getInt();
                        break;
                    case ">=":
                        evalBool = leftContainer.getInt() >= rightContainer.getInt();
                        break;
                    case "<":
                        evalBool = leftContainer.getInt() < rightContainer.getInt();
                        break;
                    case "<=":
                        evalBool = leftContainer.getInt() <= rightContainer.getInt();
                        break;
                    }      
        } else if (classToUse == Float.class) {
            switch(operator){
                    case "==":
                        evalBool = leftContainer.getFloat() == rightContainer.getFloat();
                        break;
                    case "!=":
                        evalBool = leftContainer.getFloat() != rightContainer.getFloat();
                        break;
                    case ">":
                        evalBool = leftContainer.getFloat() > rightContainer.getFloat();
                        break;
                    case ">=":
                        evalBool = leftContainer.getFloat() >= rightContainer.getFloat();
                        break;
                    case "<":
                        evalBool = leftContainer.getFloat() < rightContainer.getFloat();
                        break;
                    case "<=":
                        evalBool = leftContainer.getFloat() <= rightContainer.getFloat();
                        break;
                    }                
        } else if (classToUse == Boolean.class) {
            switch(operator){
                    case "==":
                        evalBool = leftContainer.getBoolean() == rightContainer.getBoolean();
                        break;
                    case "!=":
                        evalBool = leftContainer.getBoolean() != rightContainer.getBoolean();
                        break;
                    default:
                        throw new Exception("Error in compare primitives: boolean can't use the " + operator);
                    }                
        }
        
        if (evalBool != null) {
            return evalBool;
        } else {
            throw new Exception("Error evalBool is null!");
        }
    }
    
    public String toString() {
        return leftSide.toString() + " " + operator + " " + rightSide.toString();
    }
}
