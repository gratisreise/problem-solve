import java.util.*;

public class Main {
    static int[] a = new int[1001];
    static int[] b = new int[1001];
    static int[] psum_a = new int[2002];
    static int[] psum_b = new int[2002];
    static int want, n, m, ret;
    static Map<Integer, Integer> aCnt = new HashMap<>();
    static Map<Integer, Integer> bCnt = new HashMap<>();

    static void make(int n, int[] psum, Map<Integer, Integer> mp) {
        for (int interval = 1; interval <= n; interval++) {
            for (int start = interval; start <= n + interval - 1; start++) {
                int sum = psum[start] - psum[start - interval];
                mp.put(sum, mp.getOrDefault(sum, 0) + 1);
                if (interval == n) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        want = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            psum_a[i] = psum_a[i - 1] + a[i];
        }
        for (int i = n + 1; i <= 2 * n; i++) psum_a[i] = psum_a[i - 1] + a[i - n];
        for (int i = 1; i <= m; i++) {
            b[i] = scanner.nextInt();
            psum_b[i] = psum_b[i - 1] + b[i];
        }
        for (int i = m + 1; i <= 2 * m; i++) psum_b[i] = psum_b[i - 1] + b[i - m];
        make(n, psum_a, aCnt);
        make(m, psum_b, bCnt);
        ret = (aCnt.getOrDefault(want, 0) + bCnt.getOrDefault(want, 0));
        for (int i = 1; i < want; i++) {
            ret += (aCnt.getOrDefault(i, 0) * bCnt.getOrDefault(want - i, 0));
        }
        System.out.println(ret);
    }
}
