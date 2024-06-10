import java.util.*;

public class Main {
    static int b, n, l, idx, ret;
    static List<Pair> a = new ArrayList<>();
    static class Pair{
        int f, s ;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();


        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            a.add(new Pair(start, end));
        }

        Collections.sort(a, Comparator.comparingInt(a -> a.f));

        for (int i = 0; i < n; i++) {
            Pair pair = a.get(i);
            if (pair.s < idx) continue;
            if (idx < pair.f) {
                b = (pair.s - pair.f) / l + ((pair.s - pair.f) % l == 0 ? 0 : 1);
                idx = pair.f + b * l;
            } else {
                b = (pair.s - idx) / l + ((pair.s - idx) % l == 0 ? 0 : 1);
                idx = idx + b * l;
            }
            ret += b;
        }

        System.out.println(ret);
    }

}
