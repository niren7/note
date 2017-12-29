package string;

/**
 *  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 Input: "aba"
 Output: True
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.

 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s,i,j - 1) ||isPalindrome(s,i + 1,j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
