import java.io.*;
import java.util.*;

public class Main {
    static char[][] a = new char[54][54];
    static boolean[][] check = new boolean[54][54];
    static int[][] dp = new int[54][54];
    static int n, m;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    static boolean in(int aa, int bb) {
        return (0 <= aa && aa < n && 0 <= bb && bb < m);
    }

    static int go(int y, int x) {
        if (!in(y, x) || a[y][x] == 'H') return 0;

        if (check[y][x]) {
            System.out.println(-1);
            System.exit(0);
        }

        int ret = dp[y][x];
        if (ret != 0) return ret;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
            }
        }

        System.out.println(go(0, 0));
    }
}