import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) ret.add(num_list[i]);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}