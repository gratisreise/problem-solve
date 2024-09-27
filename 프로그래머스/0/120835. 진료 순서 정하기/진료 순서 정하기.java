import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < emergency.length; i++){
            l.add(i+1);
            mp.put(i+1, emergency[i]);
        }
        Collections.sort(l, (a, b) -> Integer.compare(mp.get(b), mp.get(a)));
        int[] ret = new int[l.size()];
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < l.size(); j++){
                if(i == l.get(j)-1) ret[i] = j+1;
            }
        }
        return ret;
    }
}