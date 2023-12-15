import java.util.*;
class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> ret = new ArrayList<>();
        for(char c : my_string.toCharArray()){
            if(c < 97) ret.add(c - '0');
        }
        Collections.sort(ret);
        return ret;
    }
}