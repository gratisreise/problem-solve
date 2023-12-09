import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(num_list);
        for(int i = 0; i < 5; i++){
            ret.add(num_list[i]);
        }
        return ret;
    }
}