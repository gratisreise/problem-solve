import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] ret = new int[k];
        Arrays.fill(ret, -1);
        // System.out.println(Arrays.toString(arr));
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0, j = 0; i < arr.length; i++){
            if(j == k) break;
            if(mp.containsKey(arr[i])) continue;
            mp.put(arr[i], 1);
            ret[j++] = arr[i];
        }
        // System.out.println(Arrays.toSTrin);
        
        return ret;
    }
}