import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int ret = 0;
        Arrays.sort(d);
        for(int i : d){
            if(i <= budget){
                ret++; budget -= i;
            }
        }
        
        return ret;
    }
}