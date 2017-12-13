package linkedlist;

/**
 *  Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not ! modify ! the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode currNode = fakeHead;
        while (currNode.next != null && currNode.next.next != null) {
            ListNode odd = currNode.next;
            ListNode even = currNode.next.next;
            odd.next = even.next;
            currNode.next = even;
            currNode.next.next = odd;
            currNode = currNode.next.next;
        }
        return fakeHead.next;
    }
}
