package string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* NumberOfSegmentsInAString Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class NumberOfSegmentsInAStringTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: countSegments(String s) 
    * 
    */ 
    @Test
    public void testCountSegments() throws Exception {
        NumberOfSegmentsInAString numberOfSegmentsInAString = new NumberOfSegmentsInAString();
        System.out.println(numberOfSegmentsInAString.countSegments("aa jk jkj    ddd"));
        System.out.println(numberOfSegmentsInAString.countSegments("a"));
        System.out.println(numberOfSegmentsInAString.countSegments(" a"));
        System.out.println(numberOfSegmentsInAString.countSegments("a "));
        System.out.println(numberOfSegmentsInAString.countSegments(" a "));
    }


} 
