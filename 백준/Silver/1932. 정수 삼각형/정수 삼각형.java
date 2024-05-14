import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[505][505];
        int[][] d = new int[505][505];

        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= i; ++j)
                a[i][j] = sc.nextInt();

        d[1][1] = a[1][1];
        for (int i = 2; i <= n; ++i)
            for (int j = 1; j <= i; ++j)
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i)
            maxSum = Math.max(maxSum, d[n][i]);

        System.out.println(maxSum);
    }
}
