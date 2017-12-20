package string;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip twoconsecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 * For example, given s = "++++", after one move, it may become one of the following states:

 [
 "--++",
 "+--+",
 "++--"
 ]

 If there is no valid move, return an empty list [].
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for(int i = 1; i < charArray.length; i++) {
            if (charArray[i-1] == '+' && charArray[i] == '+') {
                charArray[i-1] = '-';
                charArray[i] = '-';
                list.add(new String(charArray));
                charArray[i-1] = '+';
                charArray[i] = '+';
            }
        }
        return list;
    }
}
