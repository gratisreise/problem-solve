import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0) {
                ret.add(i);
                if(i * i == n) continue;
                ret.add(n / i);
            }
        }
        return ret.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}