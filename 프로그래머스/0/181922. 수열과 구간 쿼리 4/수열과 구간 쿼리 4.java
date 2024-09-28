class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end  = queries[i][1];
            int k = queries[i][2];
            for(int j = start; j <= end; j++){
                if(j % k == 0) arr[j] += 1;
            }
        }
        return arr;
    }
}