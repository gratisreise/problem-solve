import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int INF = (int)1e9;
    static int[] dp = new int[10001];
    static int n, k, coin;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coin = sc.nextInt();
            if (coin >= 10001) continue;
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        if (dp[k] == INF) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
