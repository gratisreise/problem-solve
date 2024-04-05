import java.util.Scanner;

public class Main {
    static long n, m, lo, hi, mid, ret, mx;
    static long[] a = new long[100004];

    static boolean check(long mid) {
        if (mx > mid) return false;
        long cnt = 1, temp = mid;
        for (int i = 0; i < n; i++) {
            if (temp < a[i]) {
                cnt++;
                temp = mid;
            }
            temp -= a[i];
        }
        return m >= cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        m = sc.nextLong();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            hi += a[i];
            mx = Math.max(a[i], mx);
        }
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (check(mid)) {
                hi = mid - 1;
                ret = mid;
            } else  lo = mid + 1;
        }
        System.out.println(ret);
    }
}
