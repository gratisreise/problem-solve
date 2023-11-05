import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int mx = 500000;
    static int[][] visited = new int[2][mx + 4];
    static int n, k, turn = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        boolean ok = false;

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[0][n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            k += turn;
            if (k > mx) break;
            if (visited[turn % 2][k] != 0) {
                ok = true;
                break;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int now = q.poll();
                for (int next : new int[] { now + 1, now - 1, now * 2 }) {
                    if (next < 0 || next > mx) continue;
                    if (visited[turn % 2][next] != 0) continue;
                    visited[turn % 2][next] = visited[(turn + 1) % 2][next] + 1;
                    if (next == k) {
                        ok = true;
                        break;
                    }
                    q.add(next);
                }
                if (ok) break;
            }
            if (ok) break;
            turn++;
        }

        if (ok) System.out.println(turn);
        else  System.out.println(-1);
    }
}
