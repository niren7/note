package linkedlist;

import linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* PlusOneLinkedList Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class PlusOneLinkedListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

    /**
    *
    * Method: plusOne(ListNode head)
    *
    */
    @Test
    public void testPlusOne() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        PlusOneLinkedList plusOneLinkedList = new PlusOneLinkedList();
        utils.printList(plusOneLinkedList.plusOne(node1));
    }

    @Test
    public void testPlusOne2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        PlusOneLinkedList plusOneLinkedList = new PlusOneLinkedList();
        utils.printList(plusOneLinkedList.plusOne(node1));
    }

    @Test
    public void testPlusOne3() throws Exception {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        PlusOneLinkedList plusOneLinkedList = new PlusOneLinkedList();
        utils.printList(plusOneLinkedList.plusOne(node1));
    }


} 
