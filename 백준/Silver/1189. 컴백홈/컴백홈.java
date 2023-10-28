import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] visited;
    static char[][] a;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        visited = new int[10][10];
        a = new char[10][10];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = row.charAt(j);
            }
        }

        visited[n - 1][0] = 1;
        System.out.println(go(n - 1, 0));
    }

    static int go(int y, int x) {
        if (y == 0 && x == m - 1) {
            if (visited[y][x] == k) return 1;
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (a[ny][nx] == 'T' || visited[ny][nx] != 0) continue;
            visited[ny][nx] = visited[y][x] + 1;
            ret += go(ny, nx);
            visited[ny][nx] = 0;
        }
        return ret;
    }
}
