package string.easy;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray [j];
            charArray[j] = temp;
            i++;
            j--;
        }
        return new String(charArray);
    }
}
