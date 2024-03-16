import java.util.*;
class Solution {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> ret = new ArrayList<>();
        for(int i : numlist){
            if(i % n != 0) continue;
            ret.add(i);
        }
        return ret;
    }
}