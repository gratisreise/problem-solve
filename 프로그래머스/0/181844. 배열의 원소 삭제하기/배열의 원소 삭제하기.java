import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> ret = new ArrayList<>();
        for(int i : arr){
            boolean flag = false;
            for(int j : delete_list){
                if(i == j) flag = true;
            }
            if(!flag) ret.add(i);
        }
        return ret;
    }
}