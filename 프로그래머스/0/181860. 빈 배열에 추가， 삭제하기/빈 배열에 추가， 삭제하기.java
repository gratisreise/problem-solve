import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < flag.length; i++){
            for(int j = 0; j < (flag[i] ? arr[i]*2 : arr[i]); j++){
                if(flag[i]) stk.push(arr[i]);
                else stk.pop();
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}