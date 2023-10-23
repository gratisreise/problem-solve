import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Map<String, Integer> mp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String a = sc.next();
                String b = sc.next();
                if (mp.containsKey(b)) {
                    mp.put(b, mp.get(b) + 1);
                } else {
                    mp.put(b, 1);
                }
            }

            long ret = 1;
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                ret *= (entry.getValue() + 1);
            }
            ret--;

            System.out.println(ret);
        }
    }
}
