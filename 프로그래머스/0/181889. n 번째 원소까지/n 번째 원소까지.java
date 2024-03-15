import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list, int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            l.add(num_list[i]);
        }
        return l;
    }
}