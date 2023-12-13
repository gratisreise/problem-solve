import java.util.*;
class Solution {
    public List<Long> solution(int x, int n) {
        List<Long> ret = new ArrayList<>();
        long temp = x;
        while(n-- > 0){
            ret.add(temp);
            temp += x;
        }
        return ret;
    }
}