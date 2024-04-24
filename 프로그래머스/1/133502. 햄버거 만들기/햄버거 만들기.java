import java.util.*;
class Solution {
    
    public int solution(int[] ingredient) {
        int ret = 0;
        String s = "1231";
        int start = 0;
        int end = start + 3;
        Stack<Integer> stk = new Stack<>();
        for(int i : ingredient){
            stk.push(i);
            if(stk.size() >= 4){
                String temp = "";
                while(!stk.isEmpty() && temp.length() < 4) temp = stk.pop() + temp;
                if(temp.equals(s)) ret++;
                else {
                    for(char c : temp.toCharArray()) stk.push(c - '0');
                }
            }
        }
        
        return ret;
    }
}