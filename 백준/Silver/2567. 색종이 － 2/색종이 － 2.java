import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int limit = 102;
    static int[][] board = new int[limit][limit];
    static int check(int y, int x){
        int cnt = 0;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(board[ny][nx] == 0) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            for(int y = sy;  y < sy + 10; y++){
                for(int x = sx; x < sx + 10; x++){
                    board[y][x] = 1;
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(board[i][j] == 1){
                    ret += check(i, j);
                }
            }
        }

        out.println(ret);
        out.flush();
        out.close();
    }
}