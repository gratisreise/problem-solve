import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a, b, cnt = 0;
            ArrayList<Integer>[] adj = new ArrayList[1004];
            int[] visited = new int[1004];

            for (int i = 0; i < 1004; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                adj[b].add(a);
                adj[a].add(b);
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    dfs(i, adj, visited);
                    cnt++;
                }
            }

            if (m == n - 1 && cnt == 1) {
                System.out.println("tree");
            } else {
                System.out.println("graph");
            }
        }
    }

    private static void dfs(int here, ArrayList<Integer>[] adj, int[] visited) {
        visited[here] = 1;
        for (int there : adj[here]) {
            if (visited[there] == 0) {
                dfs(there, adj, visited);
            }
        }
    }
}
