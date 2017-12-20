package string;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that don't affect
 * the one-to-one mapping relationship between the string and the original binary tree.
 */

/**
 * Input: Binary tree: [1,2,3,4]
         1
       /  \
     2     3
   /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".
 */

/**
 * Input: Binary tree: [1,2,3,null,4]
       1
     /  \
   2     3
    \
     4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) {
            return result;
        }
        if (left.equals("")) {
            return result + "()" + "(" + right + ")";
        }
        if (right.equals("")) {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }

    public String tree2str2(TreeNode t) {
        return "用栈实现";
    }
}
























