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
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static void dfs(int y, int x){
        var stk = new ArrayDeque<Pair>();
        visited[y][x] = true;
        stk.push(new Pair(y, x));
        while(!stk.isEmpty()){
            Pair p = stk.pop();
            int cy = p.y;
            int cx = p.x;
            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(board[ny][nx] == 0 || visited[ny][nx]) continue;
                stk.push(new Pair(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int test = Integer.parseInt(in.readLine());
        for(int t = 0; t < test; t++){
            var st = new StringTokenizer(in.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            visited = new boolean[n][m];
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 0 || visited[i][j]) continue;
                    dfs(i, j); cnt++;
                }
            }
            out.println(cnt);
        }

        out.flush();
        out.close();
    }
}