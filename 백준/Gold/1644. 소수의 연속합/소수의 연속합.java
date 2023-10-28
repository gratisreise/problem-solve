import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] che = new boolean[4000001];
        int[] a = new int[2000001];
        int p = 0;
        int lo = 0;
        int hi = 0;
        int ret = 0;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (che[i]) continue;
            for (int j = 2 * i; j <= n; j += i) {
                che[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!che[i]) {
                a[p++] = i;
            }
        }

        while (true) {
            if (sum >= n) {
                sum -= a[lo++];
            } else if (hi == p) {
                break;
            } else {
                sum += a[hi++];
            }
            if (sum == n) {
                ret++;
            }
        }

        System.out.println(ret);
    }
}
