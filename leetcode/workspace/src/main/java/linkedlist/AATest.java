package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class AATest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(4);
        ListNode nodea = new ListNode(5);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = nodea;

        ListNode result = new ListNode(5);
        Assert.assertEquals(1,result.val);
        Assert.assertEquals(3,result.next.val);
        Assert.assertEquals(5,result.next.next.val);
        Assert.assertEquals(2,result.next.next.next.val);
        Assert.assertEquals(4,result.next.next.next.next.val);

    }

    @Test
    public void testNullInput() throws Exception {

        ListNode result = null;
        Assert.assertEquals(null,result);
    }
}
