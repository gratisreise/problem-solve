import java.util.*;
public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> ret = new ArrayList<>();
        int prev = 10000000;
        for(int i : arr){
            if(prev == i) continue;
            ret.add(i);
            prev = i;
        }
        
        

        return ret;
    }
}