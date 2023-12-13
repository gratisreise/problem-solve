import java.util.*;
class Solution {
    public Stack<Integer> solution(long n) {
        String temp = String.valueOf(n);
        Stack<Integer> ret = new Stack<>();
        for(int i = temp.length() - 1; i >= 0; i--){
            ret.add(temp.charAt(i) - '0');
        }
        return ret;
    }
}