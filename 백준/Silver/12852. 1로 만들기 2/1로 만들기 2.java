import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[1000004];
    static final int INF = 1000000000;

    static void go(int n) {
        if (n == 0) return;
        System.out.print(n + " ");

        if (n % 3 == 0 && dp[n] == dp[n / 3] + 1) {
            go(n / 3);
        } else if (n % 2 == 0 && dp[n] == dp[n / 2] + 1) {
            go(n / 2);
        } else if (n - 1 >= 0 && dp[n] == dp[n - 1] + 1) {
            go(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp, INF);
        dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }

        System.out.println(dp[n]);
        go(n);
    }
}