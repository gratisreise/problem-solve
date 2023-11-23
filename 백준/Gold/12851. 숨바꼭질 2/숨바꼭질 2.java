import java.util.*;

public class Main {
    static final int mx = 200004;
    static int n, k;
    static int[] a = new int[mx];
    static int[] visited = new int[mx];
    static int[] cnt = new int[mx];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited[n] = 1;
        cnt[n] = 1;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next >= mx) continue;
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    q.add(next);
                } else if (visited[next] == visited[now] + 1) {
                    cnt[next] += cnt[now];
                }
            }
        }
        System.out.println(visited[k] - 1);
        System.out.println(cnt[k]);
    }
}