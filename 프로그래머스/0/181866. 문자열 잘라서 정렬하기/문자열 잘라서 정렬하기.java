import java.util.*;
class Solution {
    public List<String> solution(String myString) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(char c : myString.toCharArray()){
            if(c == 'x' && temp.length() > 0){
                ret.add(temp);
                temp = "";
            } else if(c != 'x') {
                temp += c;
                
            }
        }
        if(temp.length() > 0) ret.add(temp);
        
        Collections.sort(ret);
        return ret;
    }
}