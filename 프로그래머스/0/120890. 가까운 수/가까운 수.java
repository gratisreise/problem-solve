import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int ret = 0;
        int[] temp1 = new int[array.length];
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++){
            temp1[i] = Math.abs(n - array[i]);
        }
        int min = 100000000;
        int min_idx = 0;
        for(int i : temp1){
            min = Math.min(min, i);
        }
        for(int i = 0; i < temp1.length; i++){
            if(temp1[i] == min) {
                min_idx = i;
                break;
            }
        }
        ret = array[min_idx];
        
        
        return ret;
    }
}