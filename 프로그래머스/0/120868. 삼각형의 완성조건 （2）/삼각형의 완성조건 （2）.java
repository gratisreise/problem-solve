import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int ret = 0;
        Arrays.sort(sides);
        int small = sides[1] - sides[0];
        int big = sides[1] + sides[0];
        
        ret = big - small - 1;
        return ret;
    }
}