import java.util.*;

public class Main {
    static int n, l, r, ret, sum;
    static int[][] a, visited;
    static List<Pair> v = new ArrayList();

    static class Pair {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = 1;
        v.add(new Pair(y, x));
        sum += a[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (visited[ny][nx] != 0) continue;
            if (Math.abs(a[ny][nx] - a[y][x]) < l || Math.abs(a[ny][nx] - a[y][x]) > r) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        a = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (true) {
            boolean flag = false;
            visited = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] != 0) continue;
                    v.clear();
                    sum = 0;
                    dfs(i, j);
                    if (v.size() == 1) continue;
                    flag = true;
                    for (Pair it : v) a[it.f][it.s] = (sum / v.size());
                }
            }
            if (!flag) break;
            ret++;
        }
        System.out.println(ret);
    }
}
