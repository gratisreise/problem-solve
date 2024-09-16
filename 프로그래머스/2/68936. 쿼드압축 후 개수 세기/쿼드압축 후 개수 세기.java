import java.util.*;
class Solution {
    private static int[] ret = new int[2];
    private static int[][] arrs;
    public int[] solution(int[][] arr) {
        arrs = arr;
        quad(0, 0, arr.length);
        return ret;
    }
    private void quad(int y, int x, int n){
        if(n == 1) {
            ret[arrs[y][x]] += 1;
            return;
        }
        int num = arrs[y][x];
        for(int i = y; i < y + n; i++){
            for(int j = x; j < x + n; j++){
                if(arrs[i][j] != num){
                    quad(y, x, n / 2);
                    quad(y, x + n / 2, n / 2);
                    quad(y + n / 2, x, n / 2);
                    quad(y + n / 2, x + n / 2, n / 2);
                    return;
                }
            }
        }
        ret[num] += 1;
    }
}