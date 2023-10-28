import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int cnt = 0;
        ArrayList<Integer> v = new ArrayList<>();

        while (x != 0) {
            v.add(x % 2);
            x /= 2;
        }

        for (int i : v) {
            if (i == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
