package linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int sum = carry;
            if(node1 != null) {
                sum = sum + node1.val;
                node1 = node1.next;
            }
            if(node2 != null) {
                sum = sum + node2.val;
                node2 = node2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        if(carry == 1) {
            curr.next = new ListNode(1);
        }
        return result.next;
    }
}
