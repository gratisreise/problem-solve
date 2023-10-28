import java.util.Scanner;

public class Main {
    static int n;
    static int[] a, b;
    static int p, minu, mult, divi;
    static int ret = -1_000_000_001;
    static int ret2 = 1_000_000_001;

    public static void go(int index, int cur, int plus, int minus, int mul, int div) {
        if (index == n - 1) {
            ret = Math.max(cur, ret);
            ret2 = Math.min(ret2, cur);
            return;
        }
        if (plus > 0) {
            go(index + 1, cur + a[index + 1], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            go(index + 1, cur - a[index + 1], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            go(index + 1, cur * a[index + 1], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            go(index + 1, cur / a[index + 1], plus, minus, mul, div - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        p = scanner.nextInt();
        minu = scanner.nextInt();
        mult = scanner.nextInt();
        divi = scanner.nextInt();

        go(0, a[0], p, minu, mult, divi);

        System.out.println(ret);
        System.out.println(ret2);
    }
}
