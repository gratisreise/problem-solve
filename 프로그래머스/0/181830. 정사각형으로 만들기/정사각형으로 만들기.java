class Solution {
    public int[][] solution(int[][] arr) {
        int n = 0;
        if(arr.length > arr[0].length) n = arr.length;
        else n = arr[0].length;
        
        int[][] ret = new int[n][n];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                ret[i][j] = arr[i][j];
            }
        }
        
        
        
        return ret;
    }
}