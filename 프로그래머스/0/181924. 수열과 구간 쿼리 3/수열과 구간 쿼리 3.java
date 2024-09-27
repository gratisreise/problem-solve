class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int n1 = queries[i][0];
            int n2 = queries[i][1];
            int temp = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = temp;
        }
        return arr;
    }
}