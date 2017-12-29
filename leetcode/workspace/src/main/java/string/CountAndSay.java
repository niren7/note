package string;

/**
 * 题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，
 * 因为上次字符串有1个1，所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；
 * n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211
 */
/**
 1.    1
 2.    11
 3.    21
 4.    1211
 5.    111221
 6.    312211
 7.    13112221
 8.    1113213211
 9.    31131211131221
 10.   13211311123113112211
 */

/**
 * 考虑为什么只会出现1,2,3
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n-1) + "*";
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < charArray.length; i++) {
            if(charArray[i] == charArray[i-1]) {
                count++;
            } else {
                sb.append("" + count + String.valueOf(charArray[i-1]));
                count = 1;
            }
        }
        return sb.toString();
    }
}
