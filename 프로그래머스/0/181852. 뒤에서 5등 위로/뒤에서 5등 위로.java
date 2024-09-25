import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(num_list);
        for(int i = 5; i < num_list.length; i++) ret.add(num_list[i]);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}