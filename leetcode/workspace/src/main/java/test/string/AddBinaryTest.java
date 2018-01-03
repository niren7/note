package test.string; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.easy.AddBinary;

/** 
* AddBinary Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class AddBinaryTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addBinary(String a, String b) 
    * 
    */ 
    @Test
    public void testAddBinary() throws Exception {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1","111"));
        System.out.println(addBinary.addBinary("001","111"));
        System.out.println(addBinary.addBinary("111","111"));
    }


} 
