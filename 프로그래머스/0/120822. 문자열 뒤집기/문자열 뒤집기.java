import java.util.*;
class Solution {
    public String solution(String my_string) {
        String ret = "";
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < my_string.length(); i++){
            stk.push(my_string.charAt(i));
        }
        while(stk.size() > 0){
            ret += stk.pop();
        }
        return ret;
    }
}