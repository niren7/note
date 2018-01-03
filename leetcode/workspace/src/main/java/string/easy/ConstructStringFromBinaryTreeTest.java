package string.easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/** 
* ConstructStringFromBinaryTree Tester. 
* 
* @author <zhouxiangmin> 
* @version 1.0 
*/ 
public class ConstructStringFromBinaryTreeTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: tree2str(data.TreeNode t)
    * 
    */ 
    @Test
    public void testTree2str() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        System.out.println(constructStringFromBinaryTree.tree2str(treeNode1));
    }

    @Test
    public void testTree2str2() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        System.out.println(constructStringFromBinaryTree.tree2str(treeNode1));
    }


    @Test
    public void testTree2str3() throws Exception {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        System.out.println(constructStringFromBinaryTree.tree2str(treeNode1));
    }
} 
