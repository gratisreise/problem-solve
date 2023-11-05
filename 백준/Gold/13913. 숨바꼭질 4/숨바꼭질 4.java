import java.util.*;

public class Main {
    static final int mx = 200000;
    static int n, k;
    static int[] visited;
    static int[] prev;
    static ArrayList<Integer> v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        prev = new int[mx + 4];
        visited = new int[mx + 4];
        v = new ArrayList<>();
        visited[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[] { now - 1, now + 1, now * 2 }) {
                if (next < 0 || next > mx) continue;
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                    prev[next] = now;
                }
            }
        }

        for (int i = k; i != n; i = prev[i]) v.add(i);
        v.add(n);
        Collections.reverse(v);

        System.out.println(visited[k] - 1);
        for (int i : v) System.out.print(i + " ");
    }
}
