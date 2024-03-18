class Solution {
    public int[][] solution(int n) {
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) ret[i][j] = 1;
                else ret[i][j] = 0;
            }
        }
        return ret;
    }
}