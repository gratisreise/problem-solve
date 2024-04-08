import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int k) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < arr.length && ret.size() < k; i++){
            if(ret.indexOf(arr[i]) == -1) ret.add(arr[i]);
        }
        while(ret.size() < k) ret.add(-1);
        return ret;
    }
}