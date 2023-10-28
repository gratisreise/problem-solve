import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int mx = 200000;
    static int n, k;
    static int[] visited = new int[mx + 4];
    static int[] prev = new int[mx + 4];
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();

        visited[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[] { now - 1, now + 1, now * 2 }) {
                if (next < 0 || next > mx)
                    continue;
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                    prev[next] = now;
                }
            }
        }

        for (int i = k; i != n; i = prev[i]) {
            v.add(i);
        }
        v.add(n);
        Collections.reverse(v);

        System.out.println(visited[k] - 1);
        for (int i : v) {
            System.out.print(i + " ");
        }
    }
}
