import java.util.Scanner;

public class Main {
    static int[] a = new int[100004]; // 배열 크기 수정
    static int ret;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (m > 200000) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] + a[j] == m) {
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }
}
