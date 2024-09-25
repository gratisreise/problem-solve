import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> ret = new ArrayList<>();
        while(n != 1){
            ret.add(n);
            if(n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
        }
        ret.add(1);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}