import java.util.*;

public class Main {
    static int n;
    static int[] a = new int[1030];
    static List<Integer>[] ret = new ArrayList[14];

    static void go(int s, int e, int level) {
        if (s > e) return;
        if (s == e) {
            ret[level].add(a[s]);
            return;
        }

        int mid = (s + e) / 2;
        ret[level].add(a[mid]);
        go(s, mid - 1, level + 1);
        go(mid + 1, e, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int end = (int) Math.pow(2, n) - 1;
        for (int i = 0; i < 14; i++) ret[i] = new ArrayList<>();
        for (int i = 0; i < end; i++) a[i] = sc.nextInt();
        go(0, end, 1);
        for (int i = 1; i <= n; i++) {
            for (int j : ret[i]) System.out.print(j + " ");
            System.out.println();
        }
    }
}
