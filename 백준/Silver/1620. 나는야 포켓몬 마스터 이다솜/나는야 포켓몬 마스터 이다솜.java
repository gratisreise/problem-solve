import java.util.*;

public class Main {
    static int n, m;
    static String s;
    static Map<String, Integer> mp = new HashMap<>();
    static String[] a = new String[100004];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            mp.put(s, i + 1);
            a[i + 1] = s;
        }

        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            if (s.matches("-?\\d+")) { // 숫자인지 확인
                int index = Integer.parseInt(s);
                System.out.println(a[index]);
            } else {
                System.out.println(mp.get(s));
            }
        }
    }
}
