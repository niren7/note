package test.string.medium; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import string.medium.OutputContestMatches;

/** 
* OutputContestMatches Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class OutputContestMatchesTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: findContestMatch(int n) 
    * 
    */ 
    @Test
    public void testFindContestMatch() throws Exception {
        OutputContestMatches outputContestMatches = new OutputContestMatches();
        System.out.println(outputContestMatches.findContestMatch(2));
        System.out.println(outputContestMatches.findContestMatch(4));
        System.out.println(outputContestMatches.findContestMatch(8));
        System.out.println(outputContestMatches.findContestMatch(16));
    }

    @Test
    public void testfindContestMatchRecursion() throws Exception {
        OutputContestMatches outputContestMatches = new OutputContestMatches();
        System.out.println(outputContestMatches.findContestMatchRecursion(2));
        System.out.println(outputContestMatches.findContestMatchRecursion(4));
        System.out.println(outputContestMatches.findContestMatchRecursion(8));
        System.out.println(outputContestMatches.findContestMatchRecursion(16));
    }


} 
