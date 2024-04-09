import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean ret = false;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == '(' && c == ')') stk.pop();
            else stk.push(c);
        }
        if(stk.isEmpty()) ret = true;
        return ret;
    }
}