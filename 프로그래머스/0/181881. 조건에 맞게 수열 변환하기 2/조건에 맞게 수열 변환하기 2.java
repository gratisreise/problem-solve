import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int ret = 0;
        //작업 반복
        while(true){
            //작업실행
            int[] temp = Arrays.copyOf(arr, arr.length);
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= 50 && arr[i] % 2==0){
                    arr[i] = arr[i] / 2;
                } else if(arr[i] < 50 && arr[i] % 2 != 0){
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            boolean flag = false;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] != temp[i]){
                    flag = true;
                    break;
                }
            }
            if(!flag) break;
            ret++;
        }
        return ret;
    }
}