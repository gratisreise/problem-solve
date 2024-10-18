import java.util.*;
class Solution {
    private boolean isCorrect(char[] str, int offset){
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < str.length; i++){
            char c = str[(i + offset) % str.length];
            switch(c){
                    case '(' -> stk.push(')');
                    case '{' -> stk.push('}');
                    case '[' -> stk.push(']');
                    case ')', '}', ']' ->{
                        if(stk.isEmpty()) return false;
                        if(stk.pop() != c) return false;
                    }
            }
        }
        
        return stk.isEmpty();
    }
    public int solution(String s) {
        char[] str = s.toCharArray();
        
        int ret = 0;
        for(int offset = 0; offset < str.length; offset++){
            if(isCorrect(str, offset)) ret++;
        }
        return ret;
    }
}
/*
1. 회전
2. 짝짓기

*/