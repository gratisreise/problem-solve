import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        int end = num_list.length;
        int temp1 = num_list[end - 1];
        int temp2 = num_list[end - 2];
        if(temp1 > temp2){
            for(int i : num_list) ret.add(i);
            ret.add(temp1 - temp2);
        } else {
            for(int i : num_list) ret.add(i);
            ret.add(temp1 * 2);
        }
        return ret;
    }
}
//마지막 > 그전 -> 마지막 - 그전 | 마지막 <= 그전 -> 마지막 *= 2;