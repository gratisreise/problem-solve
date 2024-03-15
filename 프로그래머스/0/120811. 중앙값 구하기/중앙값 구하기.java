import java.util.*;
class Solution {
    public int solution(int[] array) {
        int ret = 0;
        List<Integer> l = new ArrayList<>();
        for(int i : array) l.add(i);
        Collections.sort(l);
        
        ret = l.get(l.size()/2);
        
        
        return ret;
    }
}

// 1, 2, 3, 4, 5;
// 0, 1, 2;