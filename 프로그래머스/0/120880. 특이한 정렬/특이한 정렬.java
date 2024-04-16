import java.util.*;
class Solution {
    public int[] solution(int[] num, int n) {
        int[] answer = {};
        int m = num.length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m - 1; j++){
                if(Math.abs(num[j]-n) == Math.abs(num[j + 1] - n) && num[j] > num[j + 1]) continue;
                if(Math.abs(num[j] - n) >= Math.abs(num[j + 1] - n)){
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        return num;
    }
}