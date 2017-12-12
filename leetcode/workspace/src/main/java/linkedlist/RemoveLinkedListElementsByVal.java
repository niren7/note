package linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElementsByVal {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode currNode = head;
        ListNode prevNode = fakeHead;
        while(currNode != null) {
            if(currNode.val == val) {
                prevNode.next = currNode.next;
            } else {
                prevNode = prevNode.next;
            }
            currNode = currNode.next;
        }
        return fakeHead.next;
    }
}
