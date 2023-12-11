import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[][] intervals) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++){
                ret.add(arr[j]);
            }
        }
        return ret;
    }
}