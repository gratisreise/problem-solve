import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        for(int i = num_list.length - 1; i >= 0; i--) ret.add(num_list[i]);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}