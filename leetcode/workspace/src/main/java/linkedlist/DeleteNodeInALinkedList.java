package linkedlist;

/**
 *  Write a function to delete a node (except the tail不要求删除尾节点) in a singly linked list, given only access to that node.
 *
 *  Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


/**
 * 通过复制后一个节点的值到该节点并将指针指向后面第二个节点来实现
 */
