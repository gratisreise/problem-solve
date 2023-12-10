import java.util.*;
class Solution {
    public List<String> solution(String my_string) {
        String[] strArr = my_string.split(" ");
        List<String> ret = new ArrayList<>();
        for(String s : strArr){
            if(s.equals("")) continue;
            ret.add(s);
        }
        
        return ret;
    }
}