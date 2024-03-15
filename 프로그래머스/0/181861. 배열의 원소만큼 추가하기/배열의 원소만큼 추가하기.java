import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        
        for(int i : arr){
            for(int j = 0; j < i; j++){
                ret.add(i);
            }
        }
        
        return ret;
    }
}