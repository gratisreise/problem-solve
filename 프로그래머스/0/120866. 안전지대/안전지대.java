class Solution {
    public int solution(int[][] board) {
        int ret = 0;
        int[] dy = {-1, -1,  1, 1, 1, 0, 0, -1};
        int[] dx = {-1, 1, 1, -1, 0, 1, -1, 0};
        int yl = board.length;
        int xl = board[0].length;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(board[i][j] == 1){
                    int y = i;
                    int x = j;
                    for(int k = 0; k < 8; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(ny < 0 || nx < 0 || ny >= yl || nx >= xl) continue;
                        if(board[ny][nx] != 1) board[ny][nx] = 2;
                    }
                    
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(board[i][j] == 0) ret++;
            }
        }
         
        
        return ret;
    }
}