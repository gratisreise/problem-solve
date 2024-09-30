import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[][] queries) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int temp = queries[i][2];
            int min = 1000000;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if(arr[j] > temp){
                    min = Math.min(min, arr[j]);
                }
            }
            if(min == 1000000) ret.add(-1);
            else ret.add(min);
        }
        return ret;
    }
}