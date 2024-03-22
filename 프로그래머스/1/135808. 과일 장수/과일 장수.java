import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int ret = 0;
        Integer[] temp = new Integer[score.length];
        for(int i = 0; i < score.length; i++){
            temp[i] = score[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());
        int j = 0;
        for(int i = 0; i < temp.length; i++){
            j++;
            if(j == m) {
                ret += temp[i] * j;
                j = 0;
            }
        }
        
        return ret;
    }
}