package linkedlist;

/**
 *
 * Reverse a singly linked list.
 *
 * Hint：
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        while(head != null) {
            ListNode temp = head.next;
            //将指针反向
            head.next = prevNode;
            //后移
            prevNode = head;
            //后移
            head = temp;
        }
        return prevNode;
    }

    //递归解法
    public ListNode reverseList2(ListNode head) {
        return reverseListByRecursion(head,null);
    }

    public ListNode reverseListByRecursion(ListNode head,ListNode prevNode) {
        if (head == null) {
            return prevNode;
        }
        ListNode temp = head.next;
        head.next = prevNode;
        prevNode = head;
        head = temp;
        return reverseListByRecursion(head,prevNode);
    }
}
