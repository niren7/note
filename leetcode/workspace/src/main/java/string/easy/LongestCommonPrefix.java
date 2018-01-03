package string.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if(strs != null && stringBuilder.length() > 0) {
            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if(b.length > i && b[i] == a[i]) {
                    stringBuilder.append(a[i]);
                } else {
                    return stringBuilder.toString();
                }
            }
        }
        return stringBuilder.toString();
    }
}
