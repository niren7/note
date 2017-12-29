package linkedlist;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AddTwoNumbersII Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class AddTwoNumbersIITest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addTwoNumbers(data.ListNode l1, data.ListNode l2)
    * 
    */ 
    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(1);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        utils.printList(addTwoNumbersII.addTwoNumbers(node1,node5));
    } 


} 
