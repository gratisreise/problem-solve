import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            int cnt = 1, ret = 1;
            while (true) {
                if (cnt % n == 0) {
                    System.out.println(ret);
                    break;
                } else {
                    cnt = cnt * 10 + 1;
                    cnt %= n;
                    ret++;
                }
            }
        }
    }
}