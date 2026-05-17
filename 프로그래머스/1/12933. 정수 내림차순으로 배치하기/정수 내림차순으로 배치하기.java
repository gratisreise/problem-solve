import java.util.*;
class Solution {
    public long solution(long n) {
        String temp = String.valueOf(n);
        String ret = "";
        List<Integer> l = new ArrayList<>();
        for(char c : temp.toCharArray()){
            l.add(c - '0');
        }
        Collections.sort(l);
        for(int i = l.size()-1; i >= 0; i--){
            ret += l.get(i);
        }
        return Long.parseLong(ret);
    }
}