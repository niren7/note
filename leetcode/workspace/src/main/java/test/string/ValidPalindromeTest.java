package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.ValidPalindrome;

/** 
* ValidPalindrome Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ValidPalindromeTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: isPalindrome(String s) 
    * 
    */ 
    @Test
    public void testIsPalindrome() throws Exception {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(""));
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));

        System.out.println(validPalindrome.isPalindrome2(""));
        System.out.println(validPalindrome.isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome2("race a car"));
    }


} 
