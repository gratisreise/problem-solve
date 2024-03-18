import java.util.*;
class Solution {
    public List<Integer> solution(int start, int end_num) {
        List<Integer> ret = new ArrayList<>();
        for(int i = start; i >= end_num; i--){
            ret.add(i);
        }
        return ret;
    }
}