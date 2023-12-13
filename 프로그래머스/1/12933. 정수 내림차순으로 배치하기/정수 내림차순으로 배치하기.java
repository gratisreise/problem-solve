import java.util.*;
class Solution {
    public long solution(long n) {
        String temp = String.valueOf(n);
        String ret = "";
        StringBuilder temp1;
        List<Integer> l = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for(char c : temp.toCharArray()){
            l.add(c - '0');
        }
        Collections.sort(l);
        for(int i : l) stk.push(i);
        while(!stk.isEmpty()){
            ret += (char)(stk.pop() + '0');
        }
        return Long.parseLong(ret);
    }
}