import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for(int i : arr) ret.add(i);
        int mn = Integer.MAX_VALUE;
        int mnIdx = -1;
        for(int i = 0; i < arr.length; i++){
            if(mn > arr[i]){
                mn = arr[i];
                mnIdx = i;
            }
        }
        ret.remove(mnIdx);
        if(ret.size() == 0) ret.add(-1);
        return ret;
    }
}