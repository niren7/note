package linkedlist;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* PalindromeLinkedList Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 8, 2017</pre> 
* @version 1.0 
*/ 
public class PalindromeLinkedListTest { 

    private PalindromeLinkedList palindromeLinkedList;

@Before
public void before() throws Exception {
    palindromeLinkedList = new PalindromeLinkedList();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isPalindrome(ListNode head) 
* 
*/ 
@Test
public void testIsPalindrome() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(1);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    System.out.println(palindromeLinkedList.isPalindrome(node1));
}
    @Test
    public void testIsPalindrome1() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(palindromeLinkedList.isPalindrome(node1));
    }

    @Test
    public void testIsPalindrome2() throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(palindromeLinkedList.isPalindrome(node1));
    }


/** 
* 
* Method: getMiddle(ListNode head) 
* 
*/ 
@Test
public void testGetMiddle() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PalindromeLinkedList.getClass().getMethod("getMiddle", ListNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: reverse(ListNode head) 
* 
*/ 
@Test
public void testReverse() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = PalindromeLinkedList.getClass().getMethod("reverse", ListNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
