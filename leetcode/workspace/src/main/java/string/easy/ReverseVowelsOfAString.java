package string.easy;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

     Example 1:
     Given s = "hello", return "holle".

     Example 2:
     Given s = "leetcode", return "leotcede".

     Note:
     The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s == null || "".equals(s)) {
            return  s;
        }
        //可以用hashset来减少时间复杂度
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(chars[left] + "")){
                left++;
            }
            while ((left < right) && !vowels.contains(chars[right] + "")) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
