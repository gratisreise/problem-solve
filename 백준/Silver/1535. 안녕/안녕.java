import java.util.Scanner;

public class Main {
    static int[] cost = new int[101];
    static int[] happy = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)  cost[i] = sc.nextInt();
        for (int i = 0; i < n; i++) happy[i] = sc.nextInt();

        int[] dp = new int[101];
        for (int i = 0; i < n; i++) {
            for (int j = 100; j > cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + happy[i]);
            }
        }

        System.out.println(dp[100]);
    }
}
