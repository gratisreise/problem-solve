import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int cnt = 1; int ret = 1;
            while (true) {
                if (cnt % n == 0) { 
                    System.out.println(ret);
                    break;
                } else {
                    cnt = (cnt * 10 + 1) % n;
                    ret++;
                }
            }
        }
    }
}
