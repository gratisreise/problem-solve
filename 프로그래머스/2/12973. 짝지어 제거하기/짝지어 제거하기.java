import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int ret = 0;
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty() && c == stk.peek()){
                stk.pop();
            } else stk.push(c);
        }
        
        if(stk.isEmpty()) ret = 1;

        return ret;
    }
}