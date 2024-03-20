import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(arr);
        for(int i : arr){
            if(i % divisor == 0) ret.add(i);
        }
        if(ret.size() == 0) ret.add(-1);
        return ret;
    }
}