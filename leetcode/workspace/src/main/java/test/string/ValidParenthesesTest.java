package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.ValidParentheses;

/** 
* ValidParentheses Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ValidParenthesesTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: isValid(String s) 
    * 
    */ 
    @Test
    public void testIsValid() throws Exception {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
    }


} 
