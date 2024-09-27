import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        String[] srr = myStr.split("a|b|c");
        List<String> ret = new ArrayList<>();
        for(String s : srr){
            if(s.isEmpty()) continue;
            ret.add(s);
        }
        if(ret.isEmpty()) return new String[]{"EMPTY"};
        return ret.stream().toArray(String[]::new);
    }
}