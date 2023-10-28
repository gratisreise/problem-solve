import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int mx = 200000;
    static int n, k;
    static int[] visited = new int[mx + 4];
    static int[] cnt = new int[mx + 4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();

        visited[n] = 1;
        q.add(n);
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[] { now - 1, now + 1, now * 2 }) {
                if (next < 0 || next > mx)
                    continue;
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
