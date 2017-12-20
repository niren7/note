package string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import string.DetectCapital;

/** 
* DetectCapital Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class DetectCapitalTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: detectCapitalUse(String word) 
    * 
    */ 
    @Test
    public void testDetectCapitalUse() throws Exception {
        DetectCapital detectCapital = new DetectCapital();
        Assert.assertTrue(detectCapital.detectCapitalUse("AAA"));
        Assert.assertTrue(detectCapital.detectCapitalUse("Abc"));
        Assert.assertTrue(detectCapital.detectCapitalUse("abc"));
        Assert.assertFalse(detectCapital.detectCapitalUse("aBc"));
        Assert.assertFalse(detectCapital.detectCapitalUse("AbcD"));
        Assert.assertTrue(detectCapital.detectCapitalUse2("AAA"));
        Assert.assertTrue(detectCapital.detectCapitalUse2("Abc"));
        Assert.assertTrue(detectCapital.detectCapitalUse2("abc"));
        Assert.assertFalse(detectCapital.detectCapitalUse2("aBc"));
        Assert.assertFalse(detectCapital.detectCapitalUse2("AbcD"));
    }

    /** 
    * 
    * Method: detectCapitalUse2(String word) 
    * 
    */ 
    @Test
    public void testDetectCapitalUse2() throws Exception { 
    //TODO: Test goes here... 
    } 


} 
