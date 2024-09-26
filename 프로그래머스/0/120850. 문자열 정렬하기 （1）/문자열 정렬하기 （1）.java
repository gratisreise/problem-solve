import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> ret = new ArrayList<>();
        for(char c : my_string.toCharArray()){
            if('0' <= c && c <= '9') ret.add(c - '0');
        }
        return ret.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}