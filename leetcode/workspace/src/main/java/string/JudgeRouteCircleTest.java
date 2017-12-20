package string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import string.JudgeRouteCircle;

/** 
* JudgeRouteCircle Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class JudgeRouteCircleTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: judgeCircle(String moves) 
    * 
    */ 
    @Test
    public void testJudgeCircle() throws Exception { 
        JudgeRouteCircle judgeRouteCircle = new JudgeRouteCircle();
        Assert.assertTrue(judgeRouteCircle.judgeCircle("LRUD"));
        Assert.assertTrue(judgeRouteCircle.judgeCircle("LRLDURUD"));
        Assert.assertFalse(judgeRouteCircle.judgeCircle("LLRRRUD"));
    }


} 
