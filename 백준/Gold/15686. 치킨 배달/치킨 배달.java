import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, ret;
    static int[][] a;
    static List<Pair> chi, home;
    static List<List<Integer>> Chi;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
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
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][n];
        chi = new ArrayList<>();
        home = new ArrayList<>();
        Chi = new ArrayList<>();
        ret = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
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

        for (List<Integer> C : Chi) { // 도시치킨거리
            int result = 0;
            for (Pair h : home) { // 치킨거리
                int _min = Integer.MAX_VALUE;
                for (int c : C) {
                    int _dist = Math.abs(h.first - chi.get(c).first) + Math.abs(h.second - chi.get(c).second);
                    _min = Math.min(_dist, _min);
                }
                result += _min;
            }
            ret = Math.min(ret, result);
        }

        System.out.println(ret);
    }
}
