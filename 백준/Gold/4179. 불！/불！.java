import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int mx = 1004;
    static final int INF = 1_000_000_000;
    static int ret = -1, n, m, y, x, sy, sx;
    static char[][] a;
    static int[][] vis_f, vis_j;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        vis_f = new int[n][m];
        vis_j = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
                vis_f[i][j] = INF;
                vis_j[i][j] = INF;
                if (a[i][j] == 'F') {
                    vis_f[i][j] = 1;
                    q.offer(new int[]{i, j});
                }
                if (a[i][j] == 'J') {
                    vis_j[i][j] = 1;
                    sy = i;
                    sx = j;
                }
            }
        }

        // 불 최단거리 배열 생성
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (a[ny][nx] == '#' || vis_f[ny][nx] != INF)
                    continue;
                vis_f[ny][nx] = vis_f[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }

        q.offer(new int[]{sy, sx});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];
            if (y == 0 || x == 0 || y == n - 1 || x == m - 1) {
                ret = vis_j[y][x];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (a[ny][nx] == '#' || vis_j[ny][nx] != INF)
                    continue;
                if (vis_j[y][x] + 1 >= vis_f[ny][nx])
                    continue;
                vis_j[ny][nx] = vis_j[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }

        if (ret == -1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(ret);
    }
}
