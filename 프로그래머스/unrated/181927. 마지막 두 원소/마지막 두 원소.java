import java.util.*;

class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        for(int i : num_list) ret.add(i);
        int a = num_list[num_list.length - 1];
        int b = num_list[num_list.length - 2];
        if(a > b){
            ret.add(a - b); 
        } else {
            ret.add(2 * a);
        }
        return ret;
    }
}