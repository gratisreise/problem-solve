import java.util.*;
class Solution {
    public List<Long> solution(int x, int n) {
        List<Long> ret = new ArrayList<>();
        for(long i = 0; i < n; i ++){
            ret.add((x + i*x));
        }   
        return ret;
    }
}