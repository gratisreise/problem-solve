import java.util.*;
public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> ret = new ArrayList<>();
        int prev = -1;
        for(int i : arr){
            if(i == prev) continue;
            ret.add(i);
            prev = i;
        }
        
        return ret;
    }
}