package string.easy;

/**
 * Given a string and an integer k,
 * you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int length = s.length();
        while (i < length) {
            int j = Math.min(i + k - 1,length - 1);
            swap(charArray,i,j);
            i = i + 2 * k;
        }
        return String.valueOf(charArray);
    }

    private void swap(char[] charArray, int i, int j) {
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
    }


}
