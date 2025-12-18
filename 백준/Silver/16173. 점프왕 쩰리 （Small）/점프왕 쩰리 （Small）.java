import java.io.*;
import java.util.*;

public class Main {
    static int[][] board, vis;
    static int n;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static void go(int y, int x){
        if(vis[n-1][n-1] == 1) return;
        int size = board[y][x];
        for(int i = 0; i < 2; i++){
            int ny = y + dy[i] * size;
            int nx = x + dx[i] * size;
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(vis[ny][nx] == 1) continue;
            vis[ny][nx] = 1;
            go(ny, nx);
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());

        board = new int[n][n];
        vis = new int[n][n];

        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis[0][0] = 1;
        go(0, 0);

        if(vis[n-1][n-1] == 1){
            out.println("HaruHaru");
        } else {
            out.println("Hing");
        }


        out.flush();
        out.close();
    }
}