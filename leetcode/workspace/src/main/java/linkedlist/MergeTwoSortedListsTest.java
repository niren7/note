package linkedlist;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MergeTwoSortedLists Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 5, 2017</pre> 
* @version 1.0 
*/ 
public class MergeTwoSortedListsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: mergeTwoLists(data.ListNode l1, data.ListNode l2)
* 
*/ 
@Test
public void testMergeTwoLists() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(3);
    ListNode node6 = new ListNode(4);
    node4.next = node5;
    node5.next = node6;
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
    ListNode head = mergeTwoSortedLists.mergeTwoLists(node1,node4);
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
} 


} 
