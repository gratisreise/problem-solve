import java.util.*;

public class Main {
    static long s, c, sum, ret;
    static long[] a;

    static boolean check(long mid) {
        long cnt = 0;
        for (int i = 0; i < s; i++) {
            cnt += a[i] / mid;
        }
        return cnt >= c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLong();
        c = sc.nextLong();
        a = new long[(int) s];
        sum = 0;
        for (int i = 0; i < s; i++) {
            a[i] = sc.nextLong();
            sum += a[i];
        }

        long lo = 1, hi = (long) 1e9;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(mid)) {
                lo = mid + 1;
                ret = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(sum - ret * c);
    }
}
