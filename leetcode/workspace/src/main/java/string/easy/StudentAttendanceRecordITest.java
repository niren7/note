package string.easy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* StudentAttendanceRecordI Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class StudentAttendanceRecordITest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: checkRecord(String s) 
    * 
    */ 
    @Test
    public void testCheckRecord() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: before() 
    * 
    */ 
    @Test
    public void testBefore() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: after() 
    * 
    */ 
    @Test
    public void testAfter() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: testCheckRecord() 
    * 
    */ 
    @Test
    public void testTestCheckRecord() throws Exception { 
        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();
        Assert.assertTrue(studentAttendanceRecordI.checkRecord("PPALLP"));
        Assert.assertTrue(studentAttendanceRecordI.checkRecord("PPAPLPLP"));

        Assert.assertFalse(studentAttendanceRecordI.checkRecord("PPALLL"));
        Assert.assertFalse(studentAttendanceRecordI.checkRecord("PPALPLPL"));
        Assert.assertFalse(studentAttendanceRecordI.checkRecord("PPALALPL"));
        Assert.assertFalse(studentAttendanceRecordI.checkRecord("AAAAA"));
    }


} 
