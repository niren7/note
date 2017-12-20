package string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import string.ReverseString;

/** 
* ReverseString Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ReverseStringTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: reverseString(String s) 
    * 
    */ 
    @Test
    public void testReverseString() throws Exception {
        ReverseString reverseString = new ReverseString();
        String str1 = reverseString.reverseString("abc");
        System.out.println(str1);
        String str2 = reverseString.reverseString("abcd");
        System.out.println(str2);
        System.out.println(reverseString.reverseString("a"));
        System.out.println(reverseString.reverseString("abcde"));
    }


} 
