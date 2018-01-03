package string.easy;

/**
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 *
 * 假设都是小写
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for(char c : s.toCharArray()){
            array[c - 'a']++;
        }
        for (int i = 0 ;i < s.length(); i++){
            if(array[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
