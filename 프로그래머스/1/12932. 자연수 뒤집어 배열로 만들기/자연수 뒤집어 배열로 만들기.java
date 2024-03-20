import java.util.*;
class Solution {
    public List<Integer> solution(long n) {
        List<Integer> ret = new ArrayList<>();
        String s = "" + n;
        for(int i = s.length() - 1; i >= 0; i--){
            ret.add((s.charAt(i) - '0'));
        }
        return ret;
    }
}