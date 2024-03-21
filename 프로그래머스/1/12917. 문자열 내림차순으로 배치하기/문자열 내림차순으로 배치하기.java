import java.util.*;
class Solution {
    public String solution(String s) {
        String ret = "";
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        for(int i = temp.length - 1; i >= 0; i--){
            ret += temp[i];    
        }
        
        return ret;
    }
}