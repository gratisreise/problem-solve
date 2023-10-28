import java.util.Scanner;

public class Main {
    static int n, l, ret;
    static int[][] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        ret = 0;

        a = new int[n][n];
        b = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
                b[j][i] = a[i][j];
            }
        }

        solve(a);
        solve(b);

        System.out.println(ret);
    }

    static void solve(int[][] arr) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int j;
            for (j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                } else if (arr[i][j] + 1 == arr[i][j + 1] && cnt >= l) {
                    cnt = 1;
                } else if (arr[i][j] - 1 == arr[i][j + 1] && cnt >= 0) {
                    cnt = -l + 1;
                } else {
                    break;
                }
            }

            if (j == n - 1 && cnt >= 0) {
                ret++;
            }
        }
    }
}
