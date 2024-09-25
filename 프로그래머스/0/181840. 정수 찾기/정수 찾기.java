import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list, int n) {
        List<Integer> l = Arrays.stream(num_list)
                                .boxed()
                                .collect(Collectors.toList());
        return l.contains(n) ? 1 : 0;
    }
}