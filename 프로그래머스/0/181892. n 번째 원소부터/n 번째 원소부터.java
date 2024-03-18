import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list, int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = n - 1; i < num_list.length; i++){
            ret.add(num_list[i]);
        }
        
        
        return ret;
    }
}