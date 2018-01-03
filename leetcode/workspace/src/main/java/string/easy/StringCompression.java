package string.easy;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class StringCompression {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0 ; read < chars.length ; read++) {
            //判断是否到了字符串尾,以及下个字符是否相同
            if(read + 1 == chars.length || chars[read] != chars[read + 1]){
                //不相同或者到了尾部,则需要先将字符记录下来
                chars[write++] = chars[anchor];
                //判断连续字符是否多于一个
                if(read > anchor) {
                    //记录字符数量
                    char[] countArray = String.valueOf(read - anchor + 1).toCharArray();
                    for (char c : countArray) {
                        chars[write++] = c;
                    }
                }
                //用anchor记录新的字符
                anchor = read + 1;
            }
        }
        System.out.println("compress后的字符数组:" + String.valueOf(chars));
        return write;
    }
}

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * Input:
 ["a","a","b","b","c","c","c"]

 Output:
 Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

 Explanation:
 "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

 Input:
 ["a"]

 Output:
 Return 1, and the first 1 characters of the input array should be: ["a"]

 Explanation:
 Nothing is replaced.

 Input:
 ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

 Output:
 Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

 Explanation:
 Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 Notice each digit has it's own entry in the array.
 */
