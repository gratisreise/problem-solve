import java.util.Scanner;

public class Main {
    static int n, m, mx, big, cnt;
    static int[][] visited;
    static int[][] a;
    static int[] compSize;
    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};

    static int dfs(int y, int x, int cnt) {
        if (visited[y][x] != 0) {
            return 0;
        }
        visited[y][x] = cnt;
        int ret = 1;
        for (int i = 0; i < 4; i++) {
            if ((a[y][x] & (1 << i)) == 0) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                ret += dfs(ny, nx, cnt);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        visited = new int[m][n];
        a = new int[m][n];
        compSize = new int[2504];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    cnt++;
                    compSize[cnt] = dfs(i, j, cnt);
                    mx = Math.max(mx, compSize[cnt]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    int a = visited[i + 1][j];
                    int b = visited[i][j];
                    if (a != b) {
                        big = Math.max(big, compSize[a] + compSize[b]);
                    }
                }
                if (j + 1 < n) {
                    int a = visited[i][j + 1];
                    int b = visited[i][j];
                    if (a != b) {
                        big = Math.max(big, compSize[a] + compSize[b]);
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(mx);
        System.out.println(big);
    }
}

