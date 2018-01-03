package string.easy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* FirstUniqueCharacterInAString Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class FirstUniqueCharacterInAStringTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: firstUniqChar(String s) 
    * 
    */ 
    @Test
    public void testFirstUniqChar() throws Exception {
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        Assert.assertTrue(firstUniqueCharacterInAString.firstUniqChar("leetcode") == 0);
        Assert.assertTrue(firstUniqueCharacterInAString.firstUniqChar("lele") == -1);
        Assert.assertTrue(firstUniqueCharacterInAString.firstUniqChar("lel") == 1);
        Assert.assertTrue(firstUniqueCharacterInAString.firstUniqChar("loveleetcode") == 2);

    }


} 
