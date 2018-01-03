package string.easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/** 
* FlipGame Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class FlipGameTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: generatePossibleNextMoves(String s) 
    * 
    */ 
    @Test
    public void testGeneratePossibleNextMoves() throws Exception {
        FlipGame flipGame = new FlipGame();
        List<String> list = flipGame.generatePossibleNextMoves("++++");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("***********");
        list = flipGame.generatePossibleNextMoves("+");
        for (String str : list) {
            System.out.println(str);
        }
    }


} 
