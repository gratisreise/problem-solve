import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int n, k, l, y, x, t, ret, idx, dir = 1;
    static int[][] a;
    static int[][] visited;
    static int time;
    static Deque<Pair> dq;
    static Pair[] _time;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n][n];
        visited = new int[n][n];
        _time = new Pair[101];
        dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
            a[y][x] = 1;
        }

        l = scanner.nextInt();
        for (int i = 0; i < l; i++) {
            t = scanner.nextInt();
            char c = scanner.next().charAt(0);
            if (c == 'D') {
                _time[i] = new Pair(t, 1);
            } else {
                _time[i] = new Pair(t, 3);
            }
        }

        dq.add(new Pair(0, 0));
        time = 0;

        while (!dq.isEmpty()) {
            time++;
            Pair pair = dq.peek();
            y = pair.first;
            x = pair.second;
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1) {
                break;
            }

            if (a[ny][nx] == 0) {
                Pair tail = dq.pollLast();
                visited[tail.first][tail.second] = 0;
            } else {
                a[ny][nx] = 0;
            }

            visited[ny][nx] = 1;
            dq.addFirst(new Pair(ny, nx));

            if (idx < l && time == _time[idx].first) {
                dir = (dir + _time[idx].second) % 4;
                idx++;
            }
        }

        System.out.println(time);
    }
}
