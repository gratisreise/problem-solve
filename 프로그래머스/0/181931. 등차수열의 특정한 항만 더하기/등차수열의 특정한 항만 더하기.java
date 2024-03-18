import java.util.*;
class Solution {
    public int solution(int a, int d, boolean[] included) {
        int ret = 0;
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < included.length; i++){
            num.add(a + d*i);
        }
        for(int i = 0; i < included.length; i++){
            if(included[i]) ret += num.get(i);
        }
        return ret;
    }
}