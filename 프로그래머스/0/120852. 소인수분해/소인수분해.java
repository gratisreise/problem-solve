import java.util.*;
class Solution {
    static int[] np;
    public List<Integer> solution(int n) {
        List<Integer> ret = new ArrayList<>();
        np = new int[n + 1];
        for(int i = 2; i <= n; i++){
            if(np[i] == 1) continue;
            for(int j = i * 2; j <= n; j+= i){
                np[j] = 1;
            }
        }
        for(int i = 2; i <= n; i++){
            if(np[i] == 1) continue;
            if(n % i == 0) ret.add(i);
        }
        return ret;
    }
}