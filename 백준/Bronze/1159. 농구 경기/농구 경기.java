import java.util.*;

public class Main {
    public static int[] cnt = new int[26];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            cnt[s.charAt(0) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 5) {
                ret.append((char)(i + 'a'));
            }
        }

        if (ret.length() > 0) {
            System.out.println(ret);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
