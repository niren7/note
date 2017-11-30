package linkedlist;

import linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReverseLinkedList Tester. 
*
* @author <Authors name> 
* @since <pre>十一月 30, 2017</pre> 
* @version 1.0 
*/ 
public class ReverseLinkedListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reverseList(ListNode head) 
* 
*/ 
@Test
public void testReverseList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: reverseList2(ListNode head) 
* 
*/ 
@Test
public void testReverseList2() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: reverseListByRecursion(ListNode head, ListNode prevNode) 
* 
*/ 
@Test
public void testReverseListByRecursion() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    reverseLinkedList.reverseList(node1);
    ListNode head = node4;
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
    System.out.println("");
    reverseLinkedList.reverseList(node4);
    head = node1;
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
    System.out.println("");
    //递归
    reverseLinkedList.reverseList2(node1);
    head = node4;
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
    System.out.println("");
    reverseLinkedList.reverseList2(node4);
    head = node1;
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
} 


} 
