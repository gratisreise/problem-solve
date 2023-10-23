import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] psum = new int[100005];
        int ret = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int temp = scanner.nextInt();
            psum[i] = psum[i - 1] + temp;
        }

        for (int i = k; i <= n; i++) {
            ret = Math.max(ret, psum[i] - psum[i - k]);
        }

        System.out.println(ret);
    }
}
