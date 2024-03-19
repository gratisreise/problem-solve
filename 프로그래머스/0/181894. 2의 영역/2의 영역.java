import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        boolean flag =  false;
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2) {start = i; break;}
        }
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == 2) {end = i; break;}
        }
        if(start == 0 && end == 0){
            ret.add(-1);
        } else {
            for(int i = start; i <= end; i++){
                ret.add(arr[i]);
            }
        }
        
        
        return ret;
    }
}