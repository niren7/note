package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.ValidPalindromeII;

/** 
* ValidPalindromeII Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ValidPalindromeIITest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: validPalindrome(String s) 
    * 
    */ 
    @Test
    public void testValidPalindrome() throws Exception {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("aba"));
        System.out.println(validPalindromeII.validPalindrome("abca"));
        System.out.println(validPalindromeII.validPalindrome("abcda"));
    }


/** 
* 
* Method: isPalindrome(String s, int i, int j) 
* 
*/ 
@Test
public void testIsPalindrome() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ValidPalindromeII.getClass().getMethod("isPalindrome", String.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
