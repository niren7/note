package linkedlist;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* RemoveLinkedListElementsByVal Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 11, 2017</pre> 
* @version 1.0 
*/ 
public class RemoveLinkedListElementsByValTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: removeElements(ListNode head, int val) 
* 
*/ 
@Test
public void testRemoveElements() throws Exception {
    ListNode node1 = new ListNode(6);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(6);
    ListNode node4 = new ListNode(3);
    ListNode node5 = new ListNode(4);
    ListNode node6 = new ListNode(5);
    ListNode node7 = new ListNode(6);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    RemoveLinkedListElementsByVal removeLinkedListElementsByVal = new RemoveLinkedListElementsByVal();
    utils.printList(removeLinkedListElementsByVal.removeElements(node1,6));
} 


} 
