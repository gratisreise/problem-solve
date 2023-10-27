import java.util.*;

public class Main {
    static int m, n, k, y, x, y1, x1, y2, x2;
    static int[][] a = new int[104][104];
    static int[][] visited = new int[104][104];
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {-1, 0, 1, 0};
    static List<Integer> ret = new ArrayList<>();

    static int dfs(int y, int x) {
        visited[y][x] = 1;
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
            if (a[ny][nx] == 1 || visited[ny][nx] == 1) continue;
            ret += dfs(ny, nx);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        while (k-- > 0) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    a[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 || visited[i][j] == 1) continue;
                ret.add(dfs(i, j));
            }
        }

        Collections.sort(ret);
        System.out.println(ret.size());

        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
}
