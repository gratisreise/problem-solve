import java.util.*;
class Solution {
    public List<String> solution(String myStr) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(char c : myStr.toCharArray()){
            if(c == 'a' || c == 'b' || c == 'c'){
                if(temp.length() > 0) 
                    {ret.add(temp);
                     temp = "";
                }
            } else temp += c;
        }
        if(temp.length() > 0) ret.add(temp);   
        else ret.add("EMPTY");
        return ret;
    }
}