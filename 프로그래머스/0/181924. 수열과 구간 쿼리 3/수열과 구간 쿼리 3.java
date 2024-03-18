class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        return arr;
    }
}