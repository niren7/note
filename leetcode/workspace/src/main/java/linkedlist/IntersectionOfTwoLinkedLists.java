package linkedlist;

/**
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 两个表的结构不能改变,可以不考虑链表有环的情况
 */
public class IntersectionOfTwoLinkedLists {
    //方法一,这种方法要求链表不能有环
    //保证两个指针在同一时间到达交叉点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode nodea = headA;
        ListNode nodeb = headB;
        //如果两个指针在第一次过达交叉点的时候就相遇了,则两个链表的交叉点即第一次的相遇点
        //如果两个指针在第一次过达交叉点的时候没有相遇,即两个链表非公共部分的链表长度不等,则让指针到达尾部的时候再指向
        //另一条链表的头部,这样两个链表肯定就会相遇在两个链表的交叉点,因为走过的路程都是一样的为两个链表的非公共部分加公共部分
        //如果没有交叉点,则两个指针到null的时候相等,然后返回null;
        while ( nodea != nodeb) {
            nodea = nodea == null ? headB : nodea.next;
            nodeb = nodeb == null ? headA : nodeb.next;
        }
        return nodea;
    }

    //方法二,取得两个链表的长度,然后指向长的链表的指针先走长的步输,再两个指针一起走,看是否能相遇
}
