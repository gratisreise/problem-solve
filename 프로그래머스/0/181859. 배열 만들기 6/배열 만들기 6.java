import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < arr.length;){
            if(stk.isEmpty()){
                stk.push(arr[i]); i++;
            } else if(stk.peek() == arr[i]){
                stk.pop(); i++;
            } else if(stk.peek() != arr[i]){
                stk.push(arr[i]); i++;
            }
        }
        if(stk.isEmpty()) return new int[]{-1};
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}