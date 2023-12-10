import java.util.*;
class Solution {
    public List<Integer> solution(String myString) {
        List<Integer> ret = new ArrayList<>();
        String[] temp = myString.split("x");
        for(String s : temp){
            ret.add(s.length());
        }
        if(myString.endsWith("x")) ret.add(0);
        return ret;
    }
}