import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        int temp = 0;
        for(int i = 1; i < arr.length * 2; i *= 2){
            if(i - arr.length > 0) {
                temp = i - arr.length;
                break;
            }
        } 
        for(int i : arr) ret.add(i);
        while(temp-- > 0) ret.add(0);
        return ret;
    }
}