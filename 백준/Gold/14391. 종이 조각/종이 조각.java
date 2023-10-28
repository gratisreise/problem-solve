import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int ret = 0;
        int[][] a = new int[4][4];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }

        for (int s = 0; s < (1 << (n * m)); s++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            ret = Math.max(ret, sum);
        }

        System.out.println(ret);
    }
}
