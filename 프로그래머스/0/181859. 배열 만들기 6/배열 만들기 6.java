import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        
        int i = 0;
        while(i < arr.length){
            if(stk.isEmpty()){
                stk.push(arr[i]);
                i++;
            } else if(!stk.isEmpty() && stk.peek() == arr[i]){
                stk.pop();
                i++;
            } else if(!stk.isEmpty() && stk.peek() != arr[i]){
                stk.push(arr[i]);
                i++;
            }
        }
        
        if(stk.isEmpty()) stk.push(-1);
        
        return stk;
    }
}