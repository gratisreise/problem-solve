import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 2;
        Arrays.sort(sides);
        if(sides[2] < sides[1] + sides[0]) answer = 1;
        return answer;
    }
}