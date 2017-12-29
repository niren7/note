package string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* CountAndSay Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class CountAndSayTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: countAndSay(int n) 
    * 
    */ 
    @Test
    public void testCountAndSay() throws Exception {
        CountAndSay countAndSay = new CountAndSay();
        for (int i = 1; i <= 10; i++) {
            System.out.println(countAndSay.countAndSay(i));
        }
    }

    @Test
    public void testCountAndSay2() throws Exception {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(15));
    }


} 
