class Solution {
    public int[][] solution(int[] num_list, int n) {
        int row = num_list.length / n;
        int col = n;
        int[][] ret = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ret[i][j] = num_list[i*n + j];
            }
        }
            
        return ret;
    }
}