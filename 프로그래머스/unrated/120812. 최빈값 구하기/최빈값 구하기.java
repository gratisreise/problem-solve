import java.util.*;
class Solution {
    public int solution(int[] array) {
        int ret = 0;
        int[] temp = new int[1004];
        Stack<Integer> stk = new Stack<>();
        for(int i : array) temp[i] += 1;
        int max = -1;
        for(int i : temp) max = Math.max(i , max);
        for(int i = 0; i <= 1000; i++){
            if(temp[i] == max){
                stk.push(i);
            };
        }
        if(stk.size() != 1){
            ret = -1;
        } else {
            ret = stk.peek();
        }
        
        return ret;
    }
}