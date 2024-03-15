import java.util.*;
class Solution {
    public List<String> solution(String my_string) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(char c : my_string.toCharArray()){
            if(c != ' '){
                temp += c;
            } else if(c == ' ' && temp.length() != 0){
                ret.add(temp);
                temp = "";
            }
        }
        if(temp.length() > 0) ret.add(temp);
        
        
        
        
        return ret;
    }
}