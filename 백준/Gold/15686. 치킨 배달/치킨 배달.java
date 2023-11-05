import java.util.*;

public class Main {
    static int n, m, ret;
    static int[][] a;
    static List<Pair> chi, home;
    static List<List<Integer>> Chi;

    static class Pair {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public static void combi(int start, List<Integer> v) {
        if (v.size() == m) {
            Chi.add(new ArrayList<>(v));
            return;
        }
        for (int i = start + 1; i < chi.size(); i++) {
            v.add(i);
            combi(i, v);
            v.remove(v.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        chi = new ArrayList<>();
        home = new ArrayList<>();
        Chi = new ArrayList<>();
        ret = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    home.add(new Pair(i, j));
                }
                if (a[i][j] == 2) {
                    chi.add(new Pair(i, j));
                }
            }
        }

        List<Integer> v = new ArrayList<>();
        combi(-1, v);

        for (List<Integer> C : Chi) {
            int result = 0;
            for (Pair h : home) { 
                int _min = Integer.MAX_VALUE;
                for (int c : C) {
                    int _dist = Math.abs(h.f - chi.get(c).f) + Math.abs(h.s - chi.get(c).s);
                    _min = Math.min(_dist, _min);
                }
                result += _min;
            }
            ret = Math.min(ret, result);
        }
        System.out.println(ret);
    }
}
