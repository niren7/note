package linkedlist;

import linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* IntersectionOfTwoLinkedLists Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class IntersectionOfTwoLinkedListsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getIntersectionNode(ListNode headA, ListNode headB) 
* 
*/ 
@Test
public void testGetIntersectionNode() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(333);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(2);
    ListNode node6 = new ListNode(1);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    ListNode nodea = new ListNode(1);
    ListNode nodeb = new ListNode(2);
    ListNode nodec = new ListNode(3);
    nodea.next = nodeb;
    nodeb.next = nodec;
    nodec.next = node3;
    IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
    System.out.println(intersectionOfTwoLinkedLists.getIntersectionNode(node1,nodea).val);
} 


} 
