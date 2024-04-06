import java.util.Scanner;

public class Main {
    static long[][] dp;

    static long go(int whole, int half) {
        if (whole == 0 && half == 0) return 1;
        if (dp[whole][half] != 0) return dp[whole][half];
        long ret = 0;
        if (whole > 0) ret += go(whole - 1, half + 1);
        if (half > 0) ret += go(whole, half - 1);
        return dp[whole][half] = ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            dp = new long[n + 1][n + 1];
            System.out.println(go(n, 0));
        }
    }
}