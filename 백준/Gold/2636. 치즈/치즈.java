import java.util.*;

public class Main {
    static int n, m, time, cheese;
    static int[][] a = new int[104][104];
    static int[][] visited = new int[104][104];
    static ArrayList<Pair> l = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = 1;
        if (a[y][x] == 1) {
            l.add(new Pair(y, x));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        time = 0;
        cheese = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            l.clear();
            dfs(0, 0);
            if (l.size() == 0) break;
            for (Pair p : l) {
                a[p.first][p.second] = 0;
            }
            cheese = l.size();
            time++;
        }

        System.out.println(time);
        System.out.println(cheese);
    }
}
