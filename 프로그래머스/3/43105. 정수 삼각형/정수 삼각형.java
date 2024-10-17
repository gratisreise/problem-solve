import java.util.*;
class Solution {
    //메모이제이션이 없다...
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < dp.length; i++) dp[i] = new int[triangle[i].length];
        dp[0][0] = triangle[0][0];
        // for(int[] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }
        for(int i = 1; i < dp.length; i++){
            // System.out.print(i+ " :: ");
            for(int j = 1; j < dp[i].length - 1; j++){
                // System.out.print(j + " ");
                dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j], triangle[i][j] + dp[i-1][j-1]);
            }
            // System.out.println();
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][dp[i].length - 1] = triangle[i][dp[i].length - 1] + dp[i-1][dp[i].length - 2];
        }
        // for(int[] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }
        int ret = -1;
        for(int i : dp[dp.length - 1]) ret = Math.max(ret, i);
        return ret;
    }
}
/*
거쳐간 숫자의 합이 가장 큰 경우
f(1) = 7
f(2) = 7 + 3 or 7 + 8
root, 
*/