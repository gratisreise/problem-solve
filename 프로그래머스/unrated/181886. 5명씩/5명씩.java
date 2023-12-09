import java.util.*;
class Solution {
    public List<String> solution(String[] names) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < names.length; i += 5){
            ret.add(names[i]);
        }
        return ret;
    }
}