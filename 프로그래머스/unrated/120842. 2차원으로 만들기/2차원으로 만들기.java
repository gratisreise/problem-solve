class Solution {
    public int[][] solution(int[] num_list, int n) {
        int row = num_list.length / n;
        int col = n;
        int[][] answer = new int[row][col];
        for(int i = 0; i < num_list.length; i++){
            int r = i / n;
            int c = i % n;
            answer[r][c] = num_list[i];
        }
        return answer;
    }
}