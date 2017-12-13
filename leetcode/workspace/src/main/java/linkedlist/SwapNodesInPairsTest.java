package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SwapNodesInPairs Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class SwapNodesInPairsTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: swapPairs(ListNode head) 
    * 
    */ 
    @Test
    public void testSwapPairs() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        utils.printList(swapNodesInPairs.swapPairs(node1));
    }

    @Test
    public void testSwapPairs1() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        utils.printList(swapNodesInPairs.swapPairs(node1));
    }

    @Test
    public void testNullInput() throws Exception {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode result = swapNodesInPairs.swapPairs(null);
        Assert.assertEquals(null,result);
    }
} 
