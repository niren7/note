package linkedlist;

import java.util.Stack;

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 *
 * 解法:https://www.cnblogs.com/Dylan-Java-NYC/p/5853057.html
 */
public class PlusOneLinkedList {
    //方法一,先将链表翻转,然后执行加1操作,运算完之后再将链表翻转

    //方法二,使用栈
    public ListNode plusOne(ListNode head) {
        if(head == null) {return head;}
        Stack<ListNode> stack = new Stack();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int carry = 1;
        //需要判断栈不为空,可能会有999 + 1 = 1000这样的情况
        while (carry == 1 && !stack.isEmpty()) {
            curr = stack.pop();
            int sum = carry + curr.val;
            curr.val = sum % 10;
            carry = sum / 10;
        }
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    //方法三,从右向左寻找第一个不是9的节点，找到后在该节点加一, 若是他后面还有节点, 说明后面的节点都是9, 所以都要变成0.
    //即123999只需找到3然后加1,后面的999变成000就可以了
}
