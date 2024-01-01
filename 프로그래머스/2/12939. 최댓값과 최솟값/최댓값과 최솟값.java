import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] ss = s.split(" ");
        List<Integer> l = new ArrayList<>();
        for(String sss : ss){
            l.add(Integer.parseInt(sss));
        }
        Collections.sort(l);
        answer = l.get(0) + " " + l.get(l.size()-1);
        return answer;
    }
}