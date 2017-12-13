package linkedlist;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 不能修改输入的list
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode currNode = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum = sum + s1.pop();
            }
            if (!s2.isEmpty()) {
                sum = sum + s2.pop();
            }
            currNode.val = sum % 10;
            ListNode head = new ListNode(0);
            head.next = currNode;
            carry = sum / 10;
            currNode = head;
        }
        if (carry == 1){
            currNode.val = 1;
        }
        return currNode.val == 0 ? currNode.next : currNode;
    }
}
