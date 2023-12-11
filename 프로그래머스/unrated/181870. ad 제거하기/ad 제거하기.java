import java.util.*;
class Solution {
    public List<String> solution(String[] strArr) {
        List<String> ret = new ArrayList<>();
        for(String s : strArr){
            if(s.contains("ad")) continue;
            else ret.add(s);
        }
        return ret;
    }
}