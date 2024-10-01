class Solution {
    public int[][] solution(int[][] arr) {
        int n = Math.max(arr.length, arr[0].length);
        int[][] ret = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i >= arr.length || j >= arr[0].length) continue;
                ret[i][j] = arr[i][j];
            }
        }
        return ret;
    }
}