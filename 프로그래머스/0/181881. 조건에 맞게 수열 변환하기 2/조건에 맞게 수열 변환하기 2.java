import java.util.*;
class Solution {
    private boolean check(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    private void process(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 50 && arr[i] % 2 == 0) arr[i] /= 2;
            else if(arr[i] < 50 && arr[i] % 2 != 0) arr[i] = arr[i] * 2 + 1;
        }
    }
    public int solution(int[] arr) {
        int ret = 0;
        int[] prev = new int[arr.length];
        process(arr);
        while(!check(prev, arr)){
            prev = Arrays.copyOf(arr, arr.length);
            process(arr);
            ret++;
        }
        if(ret == 1) return 0;
        return ret;
    }
}