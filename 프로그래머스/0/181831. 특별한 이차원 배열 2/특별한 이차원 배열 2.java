class Solution {
    public int solution(int[][] arr) {
        int ret = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] != arr[j][i]) ret = 0;
            }
        }
        
        
        return ret;
    }
}