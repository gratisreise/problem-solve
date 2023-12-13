import java.util.*;
class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> ret = new ArrayList<>();
        for(String ss : intStrs){
            int temp = Integer.parseInt(ss.substring(s, s + l));
            if(temp > k) ret.add(temp);
        }
        return ret;
    }
}