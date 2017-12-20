package linkedlist;

/**
 * Remove Nth Node From End of List
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 感觉这里的one pass应该是指遍历链表一次
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //头节点可能会被删除
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode slow = fakeNode;
        ListNode fast = fakeNode;
        //这里要多走一步以便跳出循环时slow的下一个节点就是要删除的节点
        for (int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return fakeNode.next;
    }
}
