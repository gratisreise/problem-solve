import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && (s.substring(i, i + 2).equals("pi") || s.substring(i, i + 2).equals("ka"))) {
                i += 1;
            } else if (i < s.length() - 2 && s.substring(i, i + 3).equals("chu")) {
                i += 2;
            } else {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
