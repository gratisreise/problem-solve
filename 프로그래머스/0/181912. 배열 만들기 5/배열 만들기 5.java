import java.util.*;
class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> ret = new ArrayList<>();
        for(String ss : intStrs){
            String temp1 = ss.substring(s, s + l);
            int temp2 = Integer.parseInt(temp1);
            if(temp2 > k) ret.add(temp2);
        }
        return ret;
    }
}