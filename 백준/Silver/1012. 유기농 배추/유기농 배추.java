import java.util.*;

public class Main {
    static int t, n, m, k, y, x;
    static int[][] a;
    static int[][] visited;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {-1, 0, 1, 0};
    static void dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx] != 0 || a[ny][nx] == 0) continue;
            dfs(ny, nx);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        
        while(t-- > 0){
            int ret = 0;
            a = new int[54][54];
            visited = new int[54][54];

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                a[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 0 || visited[i][j] != 0) continue;
                    dfs(i, j); ret++;
                }
            }

            System.out.println(ret);
        }
    }
}
