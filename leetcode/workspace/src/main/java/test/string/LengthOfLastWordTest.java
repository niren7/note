package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.LengthOfLastWord;

/** 
* LengthOfLastWord Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class LengthOfLastWordTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: lengthOfLastWord(String s) 
    * 
    */ 
    @Test
    public void testLengthOfLastWord() throws Exception {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World  "));
        System.out.println(lengthOfLastWord.lengthOfLastWord("  World  "));
    }


} 
