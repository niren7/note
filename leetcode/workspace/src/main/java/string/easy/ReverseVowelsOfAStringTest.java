package string.easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ReverseVowelsOfAString Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ReverseVowelsOfAStringTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: reverseVowels(String s) 
    * 
    */ 
    @Test
    public void testReverseVowels() throws Exception { 
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        System.out.println(reverseVowelsOfAString.reverseVowels("hello"));
        System.out.println(reverseVowelsOfAString.reverseVowels("leetcode"));
        System.out.println(reverseVowelsOfAString.reverseVowels("l"));
        System.out.println(reverseVowelsOfAString.reverseVowels("eo"));
        System.out.println(reverseVowelsOfAString.reverseVowels("eoi"));
    }


} 
