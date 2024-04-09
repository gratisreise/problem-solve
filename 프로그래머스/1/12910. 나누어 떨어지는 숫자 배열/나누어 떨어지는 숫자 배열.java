import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0) ret.add(arr[i]);
        }
        if(ret.size() == 0) ret.add(-1);
        return ret;
    }
}