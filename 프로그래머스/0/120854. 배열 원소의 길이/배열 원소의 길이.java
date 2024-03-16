import java.util.*;
class Solution {
    public List<Integer>  solution(String[] strlist) {
        List<Integer> ret = new ArrayList<>();
        for(String s : strlist){
            ret.add(s.length());
        }
        return ret;
    }
}