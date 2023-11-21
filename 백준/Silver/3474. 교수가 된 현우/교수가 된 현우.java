import java.util.*;

public class Main {
    static int t, n, ret2, ret5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            ret2 = ret5 = 0;
            for (int i = 2; i <= n; i *= 2) {
                ret2 += n / i;
            }
            for (int i = 5; i <= n; i *= 5) {
                ret5 += n / i;
            }
            System.out.println(Math.min(ret2, ret5));
        }
    }
}