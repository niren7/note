package string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ReverseStringII Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ReverseStringIITest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: reverseStr(String s, int k) 
    * 
    */ 
    @Test
    public void testReverseStr() throws Exception { 
        ReverseStringII reverseStringII = new ReverseStringII();
        System.out.println(reverseStringII.reverseStr("1234567890",3));
        System.out.println(reverseStringII.reverseStr("12",3));
        System.out.println(reverseStringII.reverseStr("123",3));
        System.out.println(reverseStringII.reverseStr("1234",3));
        System.out.println(reverseStringII.reverseStr("12345612",3));
    }



} 
