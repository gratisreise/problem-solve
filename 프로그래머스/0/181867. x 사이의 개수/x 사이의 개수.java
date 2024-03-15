import java.util.*;
class Solution {
    public List<Integer> solution(String myString) {
        String[] temp = myString.split("x");
        
        List<Integer> ret = new ArrayList<>();
        for(String s : temp){
            ret.add(s.length());
        }
        if(myString.charAt(myString.length() - 1) == 'x') ret.add(0);
        return ret;
    }
}