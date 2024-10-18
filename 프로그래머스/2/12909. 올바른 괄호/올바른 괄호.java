import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(char c : s.toCharArray()){
            switch(c) {
                    case '(' -> stk.push(c);
                    case ')' ->{
                        if(stk.isEmpty()) return false;
                        stk.pop();
                    }
            }
        }
        return stk.isEmpty();
    }
}
/*
아이디어: 바구니에 넣고 비교하면서 팝
*/