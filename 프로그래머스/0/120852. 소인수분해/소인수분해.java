import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        int[] prime = new int[n + 1];
        for(int i = 2; i <= n; i++){
            if(prime[i] == 1) continue;
            if(i != 2 && i % 2 == 0) prime[i] = 1;
            for(int j = 2*i; j <= n; j += i){
                prime[j] = 1;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(prime[i] == 0 && n % i == 0) ret.add(i);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}