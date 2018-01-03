package string.easy;

/**
 *  Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *      All letters in this word are capitals, like "USA".
 *      All letters in this word are not capitals, like "leetcode".
 *      Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * 检测大写格式是否正确,只有给的3种方式是正确的格式
 */

/**
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for(char c : word.toCharArray()) {
            if('Z' - c > 0) {
                capitalCount++;
            }
        }
        return capitalCount == word.length() || capitalCount == 0 || (capitalCount == 1 && 'Z' - word.charAt(0) >0);
    }
    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }
}
