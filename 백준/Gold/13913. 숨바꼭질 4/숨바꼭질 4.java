import java.util.*;

public class Main {
    static final int mx = 200000;
    static int n, k;
    static int[] prev = new int[mx + 4];
    static int[] visited = new int[mx + 4];
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited[n] = 1;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > mx) continue;
                if (visited[next] != 0) continue;
                visited[next] = visited[now] + 1;
                prev[next] = now;
                q.add(next);
            }
        }
        for (int i = k; i != n; i = prev[i]) l.add(i);
        l.add(n);
        Collections.reverse(l);
        System.out.println(visited[k] - 1);
        for (int i : l) System.out.print(i + " ");
    }
}