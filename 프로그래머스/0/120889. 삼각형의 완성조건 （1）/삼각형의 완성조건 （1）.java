import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int ret = 0;
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < sides.length; i++){
            l.add(sides[i]);
        }
        Collections.sort(l);
        int sum = l.get(0) + l.get(1);
        if(sum > l.get(2)) ret = 1;
        else ret = 2;
        return ret;
    }
}