package string;

/**
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char left, right;
        while (i < j) {
            left = s.charAt(i);
            right = s.charAt(j);
            if(!Character.isLetterOrDigit(left)) {
                i++;
            } else if (!Character.isLetterOrDigit(right)) {
                j--;
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean isPalindrome2(String s) {
        String ori = s.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
        String rev = new StringBuilder(ori).reverse().toString();
        return ori.equals(rev);
    }
}
