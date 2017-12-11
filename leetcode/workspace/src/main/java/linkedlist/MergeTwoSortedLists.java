package linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个虚拟的头结点
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null) {
            current.next = l1;
        }
        if(l2 != null) {
            current.next = l2;
        }
        return fakeHead.next;
    }
}
