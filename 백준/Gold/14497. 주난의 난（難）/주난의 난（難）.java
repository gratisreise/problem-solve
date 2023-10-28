import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int mx = 301;
    static int n, m, y1, x1, y2, x2;
    static int[][] visited = new int[mx][mx];
    static char[][] a = new char[mx][mx];
    static final int[] dy = { -1, 0, 1, 0 };
    static final int[] dx = { 0, 1, 0, -1 };
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        y1 = scanner.nextInt();
        x1 = scanner.nextInt();
        y2 = scanner.nextInt();
        x2 = scanner.nextInt();
        y1--;
        x1--;
        y2--;
        x2--;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }

        q.add(1000 * y1 + x1);
        visited[y1][x1] = 1;
        int cnt = 0;

        while (a[y2][x2] != '0') {
            cnt++;
            Queue<Integer> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                int cur = q.poll();
                int y = cur / 1000;
                int x = cur % 1000;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0)
                        continue;
                    visited[ny][nx] = cnt;
                    if (a[ny][nx] != '0') {
                        a[ny][nx] = '0';
                        temp.add(1000 * ny + nx);
                    } else {
                        q.add(1000 * ny + nx);
                    }
                }
            }
            q = temp;
        }

        System.out.println(visited[y2][x2]);
    }
}
