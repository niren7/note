package linkedlist;

import linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AddTwoNumbers Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class AddTwoNumbersTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addTwoNumbers(ListNode l1, ListNode l2) 
    * 
    */ 
    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        utils.printList(addTwoNumbers.addTwoNumbers(node1,node5));

    } 


} 
