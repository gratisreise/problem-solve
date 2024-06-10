import java.util.Scanner;

public class Main {
    static int n, k, ret;
    static String[] s;

    static void rot(int pos, int dir) {
        if (dir == 0) {
            s[pos] = s[pos].substring(1) + s[pos].charAt(0);
        } else {
            s[pos] = s[pos].charAt(s[pos].length() - 1) + s[pos].substring(0, s[pos].length() - 1);
        }
    }

    static int findL(int pos) {
        for (int i = pos; i >= 1; i--) {
            if (s[i].charAt(6) == s[i - 1].charAt(2)) {
                return i;
            }
        }
        return 0;
    }

    static int findR(int pos) {
        for (int i = pos; i <= n - 2; i++) {
            if (s[i].charAt(2) == s[i + 1].charAt(6)) {
                return i;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();
            b = (b == -1 ? 0 : 1);
            int l = findL(a);
            int r = findR(a);
            int cnt = 0;
            for (int pos = a; pos >= l; pos--) {
                rot(pos, cnt % 2 == 0 ? b : (b == 0 ? 1 : 0));
                cnt++;
            }
            cnt = 1;
            for (int pos = a + 1; pos <= r; pos++) {
                rot(pos, cnt % 2 == 0 ? b : (b == 0 ? 1 : 0));
                cnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i].charAt(0) == '1') ret++;
        }
        System.out.println(ret);
    }
}
