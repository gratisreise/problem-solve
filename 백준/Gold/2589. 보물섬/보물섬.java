import java.util.*;

public class Main {
    static int n, m, ret = 0;
    static int[][] visited;
    static char[][] a;
    static List<Pair> L;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};


    static class Pair {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        visited[y][x] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            y = p.f;
            x = p.s;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (a[ny][nx] == 'W' || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[y][x] + 1;
                ret = Math.max(ret, visited[ny][nx]);
                q.add(new Pair(ny, nx));
            }
        }
    }

    public static void solve() {
        for (Pair it : L) {
            visited = new int[n + 1][m + 1];
            bfs(it.f, it.s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        L = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'L') L.add(new Pair(i, j));
            }
        }

        solve();
        System.out.println(ret - 1);
    }
}
