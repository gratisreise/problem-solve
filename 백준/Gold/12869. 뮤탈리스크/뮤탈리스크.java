import java.util.*;

public class Main {
    static int n;
    static int[] a = new int[3];
    static int[][][] visited;
    static int[][] _a = {
        {9, 3, 1},
        {9, 1, 3},
        {3, 1, 9},
        {3, 9, 1},
        {1, 3, 9},
        {1, 9, 3}
    };

    static class A {
        int a, b, c;
        public A(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[65][65][65];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Queue<A> q = new LinkedList<>();
        q.add(new A(a[0], a[1], a[2]));
        visited[a[0]][a[1]][a[2]] = 1;

        while (!q.isEmpty()) {
            int a = q.peek().a;
            int b = q.peek().b;
            int c = q.peek().c;
            q.poll();
            if (visited[0][0][0] != 0) break;
            for (int i = 0; i < 6; i++) {
                int na = Math.max(0, a - _a[i][0]);
                int nb = Math.max(0, b - _a[i][1]);
                int nc = Math.max(0, c - _a[i][2]);
                if (visited[na][nb][nc] != 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                q.add(new A(na, nb, nc));
            }
        }

        System.out.println(visited[0][0][0] - 1);
    }
}
