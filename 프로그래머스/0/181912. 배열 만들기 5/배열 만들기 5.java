import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> ret = new ArrayList<>();
        for(String intStr : intStrs){
            int num = Integer.parseInt(intStr.substring(s, s + l));
            if(num > k) ret.add(num);
        }   
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}