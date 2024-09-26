import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = n-1; i < num_list.length; i++) l.add(num_list[i]);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}