import java.util.*;
class Solution {
    public List<Integer> solution(int l, int r) {
        List<Integer> ret = new ArrayList<>();
        for(int i = l; i <= r; i++){
            boolean flag = false;
            String s = i + "";
                for(char c : s.toCharArray()){
                    if(c == '0' || c == '5') continue;
                    flag = true;
                    break;
                }
                if(flag) continue;
                ret.add(i);
            }
        if(ret.size() == 0) ret.add(-1);
        return ret;
    }
}