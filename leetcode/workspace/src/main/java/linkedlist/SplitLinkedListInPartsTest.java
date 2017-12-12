package linkedlist;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SplitLinkedListInParts Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class SplitLinkedListInPartsTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: splitListToParts(ListNode root, int k) 
    * 
    */ 
    @Test
    public void testSplitListToParts() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts();
        ListNode[] nodes = splitLinkedListInParts.splitListToParts(node1,3);
        for (ListNode node : nodes){
            utils.printList(node);
        }
        System.out.println("***************");
        nodes = splitLinkedListInParts.splitListToParts(node1,10);
        for (ListNode node : nodes){
            utils.printList(node);
        }
        System.out.println("***************");
    } 


} 
