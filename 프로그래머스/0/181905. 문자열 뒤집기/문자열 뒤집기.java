import java.util.*;
class Solution {
    public String solution(String my_string, int s, int e) {
        String ret = "";
        String temp = "";
        for(int i = e; i >= s; i--){
            temp += my_string.charAt(i);
        }
        for(int i = 0; i < s; i++){
            ret += my_string.charAt(i);
        }
        ret += temp;
        for(int i = e + 1; i < my_string.length(); i++){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}