import java.util.*;

public class Main {
    static int n, m;
    static String[] a = new String[100004];
    static Map<String, Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            mp.put(s, i + 1);
            a[i + 1] = s;
        }
        for(int i = 0; i < m; i++){
            String s = sc.next();
            char c = s.charAt(0);
            //숫자
            if('0' <= c && c <= '9'){
                int num = Integer.parseInt(s);
                System.out.println(a[num]);
            } else {
                System.out.println(mp.get(s));
            }
        }

    }
}