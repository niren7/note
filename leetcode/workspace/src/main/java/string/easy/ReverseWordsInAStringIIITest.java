package string.easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ReverseWordsInAStringIII Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ReverseWordsInAStringIIITest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: reverseWords(String s) 
    * 
    */ 
    @Test
    public void testReverseWords() throws Exception {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        System.out.println(reverseWordsInAStringIII.reverseWords("abc jkjk jie jkdj"));
    } 


} 
