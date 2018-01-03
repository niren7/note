package string.easy;

/**
 *  Initially, there is a Robot at position (0, 0).
 *  Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(char c : moves.toCharArray()){
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
