import java.util.*;
class Solution {
    static boolean check(int a, int b, int[][] dots){
        boolean ans = false;
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i <  dots.length; i++){
            if(i == a || i == b) continue;
            l.add(i);
        }
        int c = l.get(0);
        int d = l.get(1);
        int tempincline1 = Math.abs(dots[a][0] - dots[b][0]) * 1000 / Math.abs(dots[a][1] - dots[b][1]);
        int tempincline2 = Math.abs(dots[c][0] - dots[d][0]) * 1000 / Math.abs(dots[c][1] - dots[d][1]);
        if(tempincline1 == tempincline2) ans = true;
        if(tempincline1 == 0 && tempincline2 == 0) ans = false;
        return ans;
    }
    public int solution(int[][] dots) {
        int ret = 0;
        boolean flag = false;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < i; j++){
               if(check(i, j, dots)) flag = true;
            }
        }
        if(flag) ret = 1;
        return ret;
    }
}