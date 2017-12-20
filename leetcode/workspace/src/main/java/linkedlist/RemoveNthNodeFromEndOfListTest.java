package linkedlist;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* RemoveNthNodeFromEndOfList Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class RemoveNthNodeFromEndOfListTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: removeNthFromEnd(ListNode head, int n) 
    * 
    */ 
    @Test
    public void testRemoveNthFromEnd() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        utils.printList(removeNthNodeFromEndOfList.removeNthFromEnd(node1,1));
    }

    @Test
    public void testRemoveNthFromEnd1() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        utils.printList(removeNthNodeFromEndOfList.removeNthFromEnd(node1,2));
    }

    @Test
    public void testRemoveNthFromEnd2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        utils.printList(removeNthNodeFromEndOfList.removeNthFromEnd(node1,3));
    }


} 
