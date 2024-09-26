import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String myString) {
        String[] srr = myString.split("x");
        List<String> ret = new ArrayList<>();
        for(String s : srr) if(!s.equals("")) ret.add(s);
        return ret.stream().sorted().toArray(String[]::new);
    }
}