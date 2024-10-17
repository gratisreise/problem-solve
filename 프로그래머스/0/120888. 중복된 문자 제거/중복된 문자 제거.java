import java.util.*;
class Solution {
    public String solution(String my_string) {
        Set<Character> used = new HashSet<>();
        
        StringBuilder ret = new StringBuilder();
        
        for(char c : my_string.toCharArray()){
            if(used.contains(c)) continue;
            used.add(c);
            ret.append(c);    
        }
        return ret.toString();
    }
}