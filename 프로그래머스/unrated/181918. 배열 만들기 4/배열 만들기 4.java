import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> ret = new Stack<>();
        int i = 0; 
        while(i < arr.length){
            if(ret.isEmpty()){
                ret.push(arr[i]);
                i++;
            } else {
                if(ret.peek() < arr[i]){
                    ret.push(arr[i]);
                    i++;
                } else {
                    ret.pop();
                }
            }
        }
        return ret;
    }
}