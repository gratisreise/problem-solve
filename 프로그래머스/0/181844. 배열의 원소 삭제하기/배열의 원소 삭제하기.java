import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j : delete_list) if(arr[i] == j) flag = true;
            if(flag) continue;
            ret.add(arr[i]);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}