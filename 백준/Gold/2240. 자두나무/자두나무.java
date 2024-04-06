import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] b;
    static int[][][] dp;
    static final int MIN = Integer.MIN_VALUE;

    static int go(int idx, int tree, int cnt) {
        if (cnt < 0) return MIN;
        if (idx == n) return 0;

        int ret = dp[idx][tree][cnt];
        if (ret != -1) return ret;

        ret = Math.max(go(idx + 1, tree ^ 1, cnt - 1), go(idx + 1, tree, cnt)) + (tree == (b[idx] - 1) ? 1 : 0);
        return dp[idx][tree][cnt] = ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        b = new int[n];
        dp = new int[n][2][34];

        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 34; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(Math.max(go(0, 0, m), go(0, 1, m - 1)));
    }
}