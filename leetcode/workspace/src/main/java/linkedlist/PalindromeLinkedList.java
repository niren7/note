package linkedlist;

import java.util.LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = getMiddle(head);
        ListNode right = reverse(middleNode);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        while (right != null) {
            System.out.print(right.val + ",");
            head = right.next;
        }
        int i = 0;
        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            i++;
            System.out.println("比较次数:" + i);
            head = head.next;
            right = right.next;
        }
        return true;
    }
    private ListNode getMiddle(ListNode head) {
        int i = 1;
        ListNode slow = head;
        ListNode fast = head;
        if(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }
        //链表长度为单数时,slow后移保证中间节点在左半边链表
        if(fast != null) {
            slow = slow.next;
            i++;
        }
        System.out.println("中点位置" + i);

        return head;
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
