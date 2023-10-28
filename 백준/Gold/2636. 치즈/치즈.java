import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n, m, Time, cheese;
    static int[][] a;
    static int[][] visited;
    static ArrayList<Pair> v;

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        Time = 0;
        cheese = 0;
        v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            v.clear();
            dfs(0, 0);
            if (v.size() == 0) break;
            for (Pair pair : v) {
                a[pair.first][pair.second] = 0;
            }
            cheese = v.size();
            Time++;
        }

        System.out.println(Time);
        System.out.println(cheese);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = 1;
        if (a[y][x] == 1) {
            v.add(new Pair(y, x));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx] == 1) continue;
            dfs(ny, nx);
        }
    }
}
