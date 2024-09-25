import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> l = new ArrayList<>();
        for(int i : numlist) if(i % n == 0) l.add(i);
        return l.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}