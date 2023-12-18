import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        Set<Integer> ret = new HashSet<>();
        for(int i = 1; i <= n; i++){
            if(i * i > n) break;
            else if(n % i == 0){
                ret.add(i);
                ret.add(n / i);
            }
        }
        List<Integer> ret1 = new ArrayList<>();
        for(int i : ret){
            ret1.add(i);
        }
        Collections.sort(ret1);
        return ret1;
    }
}