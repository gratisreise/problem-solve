import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0,1,1,-1,-1};
    static int[] dx = {0, 1, 0, -1,-1,1,1,-1};
    static int n;
    static char count(char[][] board, int y, int x){
        int cnt = 0;
        for(int d = 0; d < 8; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(board[ny][nx] == '.') continue;
            cnt += board[ny][nx] -'0';
            if(cnt >= 10) return 'M';
        }
        return (char)(cnt + '0');
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            board[i] = in.readLine().toCharArray();
        }

        var ret = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.') ret.append('*');
                else ret.append(count(board, i, j));
            }
            ret.append("\n");
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}