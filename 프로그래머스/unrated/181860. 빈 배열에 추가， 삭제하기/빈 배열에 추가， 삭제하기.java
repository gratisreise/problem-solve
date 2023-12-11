import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] arr, boolean[] flag) {
        Stack<Integer> ret = new Stack<>();
        for(int i = 0; i < flag.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i] * 2; j++) ret.push(arr[i]);
            } else {
                for(int j = 0; j < arr[i]; j++) ret.pop();
            }
        }
        return ret;
    }
}