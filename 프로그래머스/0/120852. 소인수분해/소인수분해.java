import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        List<Integer> ret = new ArrayList<>();
        int temp = n;
        for(int i = 2; i <= n; i++){
            if(temp == 1) break;
            if(temp % i == 0){
                ret.add(i);
                while(temp % i == 0){
                    temp /= i;
                }
            }
        }
        return ret;
    }
}