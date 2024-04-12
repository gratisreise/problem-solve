import java.util.*;
class Solution {
    public String solution(String s) {
        String ret = "";
        List<Integer> l = new ArrayList<>();
        for(char c : s.toCharArray()) l.add((int)c);
        Collections.sort(l, Collections.reverseOrder());
        for(int i : l) ret += (char)(i);
        return ret;
    }
}