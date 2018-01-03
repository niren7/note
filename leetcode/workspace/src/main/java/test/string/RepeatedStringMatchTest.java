package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.RepeatedStringMatch;

/** 
* RepeatedStringMatch Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class RepeatedStringMatchTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: repeatedStringMatch(String A, String B) 
    * 
    */ 
    @Test
    public void testRepeatedStringMatch() throws Exception {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd","cdabcdab"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd","cdabcd"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd","abcd"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd","abcdabcd"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abcd","abcddabcd"));
    }


} 
