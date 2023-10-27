import java.util.*;

public class Main {
    static int n, ret = -1;
    static int[][] a = new int[104][104]; 
    static int[][] visited = new int[104][104];
    static final int[][] dump = new int[104][104];
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {-1, 0, 1, 0};
    
    static void dfs(int y, int x, int d) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (a[ny][nx] <= d || visited[ny][nx] == 1) continue;
            dfs(ny, nx, d);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int d = 0; d <= 100; d++) {
            for (int i = 0; i < n; i++) {
               for(int j = 0; j < n; j++){
                    visited[i][j] = 0;
               }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] <= d || visited[i][j] == 1) continue;
                    dfs(i, j, d);
                    cnt++;
                }
            }

            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
    }

   
}
