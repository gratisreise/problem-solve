import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0, a, ret = -10001;

        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            sum += a;
            ret = Math.max(ret, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(ret);
    }
}
