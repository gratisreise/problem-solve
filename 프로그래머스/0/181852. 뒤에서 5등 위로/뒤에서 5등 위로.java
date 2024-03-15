import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(num_list);
        for(int i = 5; i < num_list.length; i++){
            l.add(num_list[i]);
        }
        return l;
    }
}