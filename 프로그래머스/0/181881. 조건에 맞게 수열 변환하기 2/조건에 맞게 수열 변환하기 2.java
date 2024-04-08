import java.util.*;
class Solution {
    static boolean check(int[] arr1, int[] arr2){
        int n = arr1.length;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            if(arr1[i] != arr2[i]) flag = false;
        }
        
        return flag;
    }
    static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public int solution(int[] arr) {
        int ret = 0;
        int[] prev = new int[arr.length];
        while(true){
            prev = Arrays.copyOf(arr, arr.length);
            for(int i = 0; i < arr.length; i++){
                if(arr[i] % 2 == 0 && arr[i] >= 50){
                    arr[i] /= 2;
                } else if(arr[i] % 2 != 0 && arr[i] < 50){
                    arr[i] = (arr[i] * 2) + 1;
                }
            }
            ret++;
            if(check(prev, arr)) break;
        }
        ret--;
        return ret;
    }
}