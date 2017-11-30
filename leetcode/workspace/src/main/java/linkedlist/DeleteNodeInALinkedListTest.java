package linkedlist;

import linkedlist.ListNode;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DeleteNodeInALinkedList Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 30, 2017</pre> 
* @version 1.0 
*/ 
public class DeleteNodeInALinkedListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: deleteNode(ListNode node) 
* 
*/ 
@Test
public void testDeleteNode() throws Exception { 
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    ListNode head = node1;
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
    DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
    deleteNodeInALinkedList.deleteNode(node3);
    head = node1;
    System.out.println("after delete node3");
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
    deleteNodeInALinkedList.deleteNode(node1);
    head = node1;
    System.out.println("after delete node1");
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
}


} 
