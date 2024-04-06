import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[10001];
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int temp = sc.nextInt();
            if (temp >= 10001) continue;
            for (int j = temp; j <= k; j++) {
                dp[j] += dp[j - temp];
            }
        }
        System.out.println(dp[k]);
        sc.close();
    }
}
