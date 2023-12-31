import java.util.*;

public class Main {
    static int n, m;
    static int[][] a = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Pair {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Pair> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.f;
            int x = p.s;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (a[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        System.out.println(visited[n - 1][m - 1]);
    }
}