import java.util.*;
class Solution {
    public List<String> solution(String my_str, int n) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < my_str.length(); i++){
            temp += my_str.charAt(i);
            if(temp.length() == n) {
                ret.add(temp);
                temp = "";
            }
        }
        if(temp.length() > 0) ret.add(temp);
        
        
        return ret;
    }
}