import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        answer = my_string.toLowerCase();
        List<Integer> l = new ArrayList<>();
        for(char c : answer.toCharArray()){
            l.add((int)c);
        }
        Collections.sort(l);
        String ret = "";
        for(int i : l){
            ret += (char)i;
        }
        return ret;
    }
}