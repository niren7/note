package linkedlist;

import java.util.LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = getMiddle(head);
        ListNode right = reverse(middleNode);
        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
    }
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表长度为单数时,slow后移保证中间节点在左半边链表
        if(fast != null) {
            slow = slow.next;
        }

        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode temp =  head.next;
            head.next = prevNode;
            prevNode = head;
            head = temp;
        }
        return prevNode;
    }
}
