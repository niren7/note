package linkedlist;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* RemoveDuplicatesFromSortedList Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 4, 2017</pre> 
* @version 1.0 
*/ 
public class RemoveDuplicatesFromSortedListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: deleteDuplicates(ListNode head) 
* 
*/
//递归解法测试
@Test
public void testDeleteDuplicates() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
    ListNode head = removeDuplicatesFromSortedList.deleteDuplicates(node1);
    while (head != null) {
        System.out.print(head.val + ",");
        head = head.next;
    }
}

    @Test
    public void testDeleteDuplicates1() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode head = removeDuplicatesFromSortedList.deleteDuplicates(node1);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println(node1.next);
    }
    //非递归解法测试
    @Test
    public void testDeleteDuplicates2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode head = removeDuplicatesFromSortedList.deleteDuplicates0(node1);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }
    @Test
    public void testDeleteDuplicates3() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode head = removeDuplicatesFromSortedList.deleteDuplicates0(node1);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

} 
