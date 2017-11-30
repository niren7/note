package linkedlist;




/*
*
* Given a linked list, determine if it has a cycle in it.
* Follow up:
* Can you solve it without using extra space?
*
* */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //fast.next != null以避免出现空指针异常
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}












/**
 * 只有一个指向下个节点的单链表，所以一直往下移动，
 * 如果没有环的话则移动到链表的尾部
 * 如果有环的话则一直在环内移动
 */
