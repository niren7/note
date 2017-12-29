package string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* StringCompression Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class StringCompressionTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: compress(char[] chars) 
    * 
    */ 
    @Test
    public void testCompress() throws Exception {
        StringCompression stringCompression = new StringCompression();
        char[] chars = "aabbccc".toCharArray();
        System.out.println(stringCompression.compress(chars));
        chars = "a".toCharArray();
        System.out.println(stringCompression.compress(chars));
        chars = "abbbbbbbbbbbbbbbb".toCharArray();
        System.out.println(stringCompression.compress(chars));
        chars = "abab".toCharArray();
        System.out.println(stringCompression.compress(chars));
    }


} 
