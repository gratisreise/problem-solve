import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] board, visited;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int d=  0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(board[ny][nx] == 0 || visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }
    static int count(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0 || visited[i][j] != 0) continue;
                dfs(i, j);
                cnt++;
            }
        }
        return cnt;
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
            visited = new int[n][m];
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }
            out.println(count());
        }


        out.flush();
        out.close();
    }
}