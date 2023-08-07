import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else stack.push(s.charAt(i));               
            }
            if(stack.isEmpty()) return true;
            else  return false;
        }
    }