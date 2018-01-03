package string.easy;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(new StringBuffer(str).reverse().toString() + " ");
        }
        return sb.toString().trim();
    }
}
