package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.ImplementstrStr;

/** 
* ImplementstrStr Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ImplementstrStrTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: strStr(String haystack, String needle) 
    * 
    */ 
    @Test
    public void testStrStr() throws Exception {
        ImplementstrStr implementstrStr = new ImplementstrStr();
        System.out.println(implementstrStr.strStr("hello","ll"));
        System.out.println(implementstrStr.strStr("aaaaa","bba"));
    }


} 
