import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a = new int[21][21];
    static int[][][] dp = new int[21][21][3];
    static int ret = 0;

    static boolean check(int y, int x, int dir) {
        if (dir == 0 || dir == 2) {
            if (a[y][x] == 0) return true;
        } else if (dir == 1) {
            if (a[y - 1][x] == 0 && a[y][x - 1] == 0 && a[y][x] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (check(i, j + 1, 0)) dp[i][j + 1][0] += dp[i][j][0];
                if (check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][0];
                if (check(i + 1, j, 2)) dp[i + 1][j][2] += dp[i][j][2];
                if (check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][2];
                if (check(i, j + 1, 0)) dp[i][j + 1][0] += dp[i][j][1];
                if (check(i + 1, j, 2)) dp[i + 1][j][2] += dp[i][j][1];
                if (check(i + 1, j + 1, 1)) dp[i + 1][j + 1][1] += dp[i][j][1];
            }
        }

        for (int i = 0; i < 3; i++) {
            ret += dp[n][n][i];
        }

        System.out.println(ret);
    }
}