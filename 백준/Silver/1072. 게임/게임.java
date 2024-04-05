import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        long z = y * 100 / x;
        long lo = 1;
        long hi = (long) 1e9;
        long ret = -1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if ((y + mid) * 100 / (x + mid) > z) {
                ret = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ret);
    }
}