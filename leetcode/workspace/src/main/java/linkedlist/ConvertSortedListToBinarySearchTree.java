package linkedlist;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }
    private TreeNode toBST(ListNode head,ListNode tail) {
        /*ListNode slow = head;
        ListNode fast = head;
        if(head == null) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode tNode = new TreeNode(slow.val);
        tNode.left = toBST(head,slow);
        tNode.right = toBST(slow.next,tail);
        return  tNode;*/
        return null;
    }
}
