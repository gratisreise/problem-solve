import java.util.Scanner;

public class Main {
    static int n, p, lo, hi, ret, sum;
    static boolean[] che;
    static int[] a;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        che = new boolean[n + 1];
        a = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (che[i]) continue;
            for (int j = 2 * i; j <= n; j += i) {
                che[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!che[i]) a[p++] = i;
        }

        while (true) {
            if (sum >= n)  sum -= a[lo++];
            else if (hi == p) break;
            else sum += a[hi++];
            
            if (sum == n) ret++;
        }
        System.out.println(ret);
    }
}
