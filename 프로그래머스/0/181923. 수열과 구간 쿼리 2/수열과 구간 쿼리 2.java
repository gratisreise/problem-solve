class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] ret = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int temp = 10000000;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if(arr[j] > queries[i][2]) temp = Math.min(temp, arr[j]);
            }
            ret[i] = temp == 10000000 ? -1 : temp;
        }
        return ret;
    }
}