package string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* RansomNote Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class RansomNoteTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: canConstruct(String ransomNote, String magazine) 
    * 
    */ 
    @Test
    public void testCanConstruct() throws Exception {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a","b"));
        System.out.println(ransomNote.canConstruct("a","a"));
        System.out.println(ransomNote.canConstruct("aa","aab"));
        System.out.println(ransomNote.canConstruct("abb","aab"));
    }


} 
