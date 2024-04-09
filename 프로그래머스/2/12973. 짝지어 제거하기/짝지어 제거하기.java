import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == c) stk.pop();
            else stk.push(c);
        }
        if(stk.isEmpty()) return 1;
        return 0;
    }
}