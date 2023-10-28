import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 666;; i++) {
            if (String.valueOf(i).contains("666")) {
                n--;
            }

            if (n == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
