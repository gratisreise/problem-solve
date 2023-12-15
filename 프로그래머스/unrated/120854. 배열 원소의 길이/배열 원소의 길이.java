import java.util.*;
class Solution {
    public List<Integer> solution(String[] str) {
        List<Integer> ret = new ArrayList<>();
        for(String s : str){
            ret.add(s.length());
        }
        return ret;
    }
}