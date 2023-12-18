class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        if(row > col) col = row;
        else row = col;
        int[][] ret = new int[row][col];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                ret[i][j] = arr[i][j];
            }
        }
        return ret;
    }
}