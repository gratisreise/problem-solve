import java.util.*;
class Solution {
    public List<Integer> solution(int n, int k) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % k == 0) ret.add(i);
        }
        return ret;
    }
}