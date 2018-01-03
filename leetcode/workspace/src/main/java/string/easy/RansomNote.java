package string.easy;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 前一个代表赎金条,后一个代表杂志上所有字母,每个字母只能被使用一次,判断是否能构建出赎金条
 */




/**
 * NOTE:
 * You may assume that both strings contain only lowercase letters.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charAmount = new int[26];
        for(char c : magazine.toCharArray()) {
            charAmount[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(--charAmount[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}






