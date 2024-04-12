import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int ret = 0;
        int min = (int)1e9;
        Arrays.sort(array);
        for(int i : array){
            int cha = Math.abs(n - i);
            min = Math.min(cha, min);
        }
        for(int i : array){
            int cha = Math.abs(n - i);
            if(cha == min) return i;
        }
        return ret;
    }
}