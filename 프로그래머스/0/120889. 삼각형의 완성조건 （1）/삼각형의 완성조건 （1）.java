import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int ret = 2;
        Arrays.sort(sides);
        if(sides[0] + sides[1] > sides[2]) ret = 1;
        return ret;
    }
}