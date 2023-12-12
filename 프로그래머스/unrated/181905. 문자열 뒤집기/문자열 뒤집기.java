import java.util.*;
class Solution {
    public String solution(String my_string, int s, int e) {
        Stack<Character> stk = new Stack<>();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        for(int i = 0; i < my_string.length(); i++){
            if(i < s) s1 += my_string.charAt(i);
            else if(s <= i && i <= e) stk.push(my_string.charAt(i));
            else if(i > e) s3 += my_string.charAt(i);
        }
        while(!stk.isEmpty()) s1 += stk.pop();
        s1 += s3;
        
        
        return s1;
    }
}