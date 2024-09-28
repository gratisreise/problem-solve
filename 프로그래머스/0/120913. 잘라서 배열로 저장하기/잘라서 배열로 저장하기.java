import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < my_str.length(); i += n){
            int end = Math.min(i + n, my_str.length());
            ret.add(my_str.substring(i, end));
        }
        return ret.stream().toArray(String[]::new);
    }
}