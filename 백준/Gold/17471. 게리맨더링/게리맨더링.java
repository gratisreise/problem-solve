import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int INF = 1000000000;
    static int n, m, temp, ret = INF;
    static int[] comp, a, visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        comp = new int[n + 1];
        visited = new int[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            m = scanner.nextInt();
            while (m-- > 0) {
                temp = scanner.nextInt();
                adj[temp].add(i);
                adj[i].add(temp);
            }
        }

        for (int i = 1; i < (1 << n) - 1; i++) {
            for (int j = 1; j <= n; j++) {
                visited[j] = 0;
                comp[j] = 0;
            }
            int idx1 = -1, idx2 = -1;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1;
                } else {
                    idx2 = j + 1;
                }
            }

            Pair temp1 = dfs(idx1, 1);
            Pair temp2 = dfs(idx2, 0);

            if (temp1.first + temp2.first == n) {
                ret = Math.min(ret, Math.abs(temp1.second - temp2.second));
            }
        }

        System.out.println(ret == INF ? -1 : ret);
    }

    static Pair dfs(int now, int team) {
        visited[now] = 1;
        Pair ret = new Pair(1, a[now]);
        for (int next : adj[now]) {
            if (visited[next] != 0) continue;
            if (comp[now] != comp[next]) continue;
            Pair temp = dfs(next, team);
            ret.first += temp.first;
            ret.second += temp.second;
        }
        return ret;
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
