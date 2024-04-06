import java.util.Scanner;

public class Main {
    static int n, k, w, v;
    static int[] dp = new int[100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dp = new int[100001];
        n = scanner.nextInt();
        k = scanner.nextInt();
        while (n-- > 0) {
            w = scanner.nextInt();
            v = scanner.nextInt();
            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[k]);
        scanner.close();
    }
}
