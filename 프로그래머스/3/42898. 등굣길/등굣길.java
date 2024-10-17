import java.util.*;
class Solution {
    private boolean isHole(int y, int x, int[][] puddles){
        for(int[] arr : puddles){
            if(y == arr[1] && x == arr[0]) return true;
        }
        return false;
    }
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for(int y = 1; y <= n; y++){
            for(int x = 1; x <= m; x++){
                if(isHole(y, x, puddles)) continue;
                dp[y][x] += (dp[y - 1][x] + dp[y][x - 1]) % 1000000007;
            }
        }
        // for(int[] arr : dp)System.out.println(Arrays.toString(arr));
        return dp[n][m];
    }
}
/*
최단 경로의 갯수
오른쪽: x + 1, y;
아래: x, y + 1;
dp[y][x];
dp[y][x];
*/