import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++){
                ret.add(arr[j]);
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}