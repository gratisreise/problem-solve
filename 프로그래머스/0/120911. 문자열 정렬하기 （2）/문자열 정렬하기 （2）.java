import java.util.*;
class Solution {
    public String solution(String my_string) {
        List<Character> temp1 = new ArrayList<>();
        String temp2 = my_string.toLowerCase();
        String ret = "";
        
        for(char c : temp2.toCharArray()){
            temp1.add(c);
        }
        Collections.sort(temp1);
        for(char c : temp1){
            ret += c;
        }
        return ret;
    }
}