import java.util.Scanner;

public class Main {
    static char[][] a;
    static boolean[][] check;
    static int n, m;
    static int[][] dp;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static boolean in(int aa, int bb) {
        return (0 <= aa && aa <= n - 1 && 0 <= bb && bb <= m - 1);
    }

    static int go(int y, int x) {
        if (!in(y, x) || a[y][x] == 'H') return 0;
        if (check[y][x]) {
            System.out.println(-1);
            System.exit(0);
        }

        int ret = dp[y][x];
        if (ret > 0) return ret;

        check[y][x] = true;
        int value = a[y][x] - '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i] * value;
            int nx = x + dx[i] * value;
            ret = Math.max(ret, go(ny, nx) + 1);
        }

        check[y][x] = false;
        dp[y][x] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        dp = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = row.charAt(j);
            }
        }

        System.out.println(go(0, 0));
    }
}