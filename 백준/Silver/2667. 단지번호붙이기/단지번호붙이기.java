import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    static boolean isBound(int y, int x){
        return y < 0 || x < 0 || y >= n || x >= n;
    }
    static int dfs(int y, int x){
        visited[y][x] = 1;
        int ret = 1;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(isBound(ny, nx) || visited[ny][nx] != 0 || board[ny][nx] == 0) continue;
            ret += dfs(ny,nx);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        board = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i< n; i++){
            char[] row = in.readLine().toCharArray();
            for(int j =0; j < n; j++){
                board[i][j] = (row[j] - '0');
            }
        }
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i< n; i++){
            for(int j =0; j < n; j++){
                if(visited[i][j] != 0 || board[i][j] == 0) continue;
                cnt++;
                ret.add(dfs(i, j));
            }
        }
        ret.sort((a,b) -> a-b);
        out.println(cnt);
        for(int n : ret) out.println(n);
        out.flush();
        out.close();
    }
}