import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int y; int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static void dfs(int y, int x, int h){
        var stk = new ArrayDeque<Pair>();
        stk.push(new Pair(y, x));
        while(!stk.isEmpty()){
            Pair p = stk.pop();
            int cy = p.y;
            int cx = p.x;
            for(int d = 0; d < 4; d++){
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx] || board[ny][nx] <= h) continue;
                visited[ny][nx] = true;
                stk.push(new Pair(ny, nx));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret = -1;
        for(int h = 0; h <= 100; h++){
            visited = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] <= h || visited[i][j]) continue;
                    dfs(i, j, h); cnt++;
                }
            }
            ret = Math.max(ret, cnt);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}