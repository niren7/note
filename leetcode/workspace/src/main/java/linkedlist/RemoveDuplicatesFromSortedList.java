package linkedlist;


/**
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For exampleGiven 1->1->2,return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 有序链表 去重
 */
public class RemoveDuplicatesFromSortedList {
    //递归解法
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
        // 不置为空可能会造成内存泄漏
        /*if(head.val == head.next.val) {
            ListNode node = head.next;
            //置空
            head.next = null;
            head = null;
            //置空
            return node;
        } else {
            return head;
        }*/
    }
    //非递归解法
    public ListNode deleteDuplicates0(ListNode head) {
        ListNode currentNode = head;
        if(head == null || head.next == null) {
            return head;
        }
        while (currentNode != null) {
            //需要再判断currentNode.next以避免空指针
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                //这里可以删除无用的node以免内存泄露
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}
