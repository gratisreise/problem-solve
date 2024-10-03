class Solution {
    private int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    private int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public int solution(int[][] board) {
        int ret = 0;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0 || board[i][j] == -1) continue;
                for(int d = 0; d < 8; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 1) continue;
                    board[ny][nx] = -1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0) ret++;
            }
        }
        return ret;
    }
}