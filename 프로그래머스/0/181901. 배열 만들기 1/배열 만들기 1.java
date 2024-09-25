import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int k) {
        int[] answer = {};
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i++) if(i % k == 0) l.add(i);
        
        return l.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}