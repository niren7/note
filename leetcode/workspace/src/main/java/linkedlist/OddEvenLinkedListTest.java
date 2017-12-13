package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* OddEvenLinkedList Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class OddEvenLinkedListTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: oddEvenList(ListNode head) 
    * 
    */ 
    @Test
    public void testOddEvenList() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(node1);
        utils.printList(result);
        Assert.assertEquals(1,result.val);
        Assert.assertEquals(3,result.next.val);
        Assert.assertEquals(2,result.next.next.val);
        Assert.assertEquals(4,result.next.next.next.val);
    }

    @Test
    public void testOddEvenList2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(node1);
        utils.printList(result);
        Assert.assertEquals(1,result.val);
        Assert.assertEquals(3,result.next.val);
        Assert.assertEquals(5,result.next.next.val);
        Assert.assertEquals(2,result.next.next.next.val);
        Assert.assertEquals(4,result.next.next.next.next.val);
    }

    @Test
    public void testOddEvenList3() throws Exception {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode result = oddEvenLinkedList.oddEvenList(null);
        utils.printList(result);
        Assert.assertEquals(null,result);
    }


} 
