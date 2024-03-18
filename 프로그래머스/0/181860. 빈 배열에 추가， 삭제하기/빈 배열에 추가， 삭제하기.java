import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] arr, boolean[] flag) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < flag.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i] * 2; j ++){
                    stk.push(arr[i]);
                }
            } else {
                for(int j = 0; j < arr[i]; j++){
                    stk.pop();
                }
            }
        }
        return stk;
    }
}

//빈배열 x
// 정수배열 arr, boolean 배열 flag -> 매개변수
// true -> arr[i]를 2번 X에 추가
// false -> arr[i]개의 원소를 제거