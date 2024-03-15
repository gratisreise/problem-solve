import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        int end = 0;
        if(num_list[num_list.length - 1] > num_list[num_list.length - 2]){
            end = num_list[num_list.length - 1] - num_list[num_list.length - 2];
        } else {
            end = num_list[num_list.length - 1] * 2;
        }
        for(int i : num_list) ret.add(i);
        ret.add(end);
        return ret;
    }
}