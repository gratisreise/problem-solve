import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int ret = 0;
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int s = b - a;
        int e = a + b;
        for(int i = s + 1; i < e; i++){
            ret++;
        }
        return ret;
    }
}