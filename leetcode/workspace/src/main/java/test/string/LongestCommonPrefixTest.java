package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.LongestCommonPrefix;

/** 
* LongestCommonPrefix Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class LongestCommonPrefixTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: longestCommonPrefix(String[] strs) 
    * 
    */ 
    @Test
    public void testLongestCommonPrefix() throws Exception {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = new String[3];
        strs[0] = "abc";
        strs[1] = "ab";
        strs[2] = "abc";
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    } 


} 
