class Solution {
    static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
    public int solution(int[][] board) {
        int ret = 0;
        int n = board.length;
        int[][] vis = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0) continue;
                int y = i;
                int x = j;
                vis[y][x] = 1;
                for(int k = 0; k < 8; k++){
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    vis[ny][nx] = 1; 
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] != 1) ret++;
            }
        }
        return ret;
    }
}