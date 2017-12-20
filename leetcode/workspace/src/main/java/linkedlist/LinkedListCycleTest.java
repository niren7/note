package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LinkedListCycle Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 30, 2017</pre> 
* @version 1.0 
*/ 
public class LinkedListCycleTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: hasCycle(ListNode head) 
* 
*/ 
@Test
    public void testHasCycle() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        Assert.assertEquals(true,linkedListCycle.hasCycle(node1));
    }

    @Test
    public void testHasCycle2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        Assert.assertEquals(false,linkedListCycle.hasCycle(node1));
    }

} 
