import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int mx = 1501;
    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };
    static int n, m, day, swanY, swanX, y, x;
    static int[][] v_swan = new int[mx][mx];
    static int[][] visited = new int[mx][mx];
    static char[][] a = new char[mx][mx];
    static Queue<int[]> wQ = new LinkedList<>();
    static Queue<int[]> w_tempQ = new LinkedList<>();
    static Queue<int[]> sQ = new LinkedList<>();
    static Queue<int[]> s_tempQ = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'L') {
                    swanY = i;
                    swanX = j;
                }
                if (a[i][j] == '.' || a[i][j] == 'L') {
                    visited[i][j] = 1;
                    wQ.add(new int[] { i, j });
                }
            }
        }

        sQ.add(new int[] { swanY, swanX });
        v_swan[swanY][swanX] = 1;

        while (true) {
            if (moveSwan()) {
                break;
            }
            iceBreaking();
            wQ = new LinkedList<>(w_tempQ);
            sQ = new LinkedList<>(s_tempQ);
            w_tempQ.clear();
            s_tempQ.clear();
            day++;
        }

        System.out.println(day);
    }

    static void iceBreaking() {
        while (!wQ.isEmpty()) {
            int[] pos = wQ.poll();
            y = pos[0];
            x = pos[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (a[ny][nx] == 'X') {
                    visited[ny][nx] = 1;
                    w_tempQ.add(new int[] { ny, nx });
                    a[ny][nx] = '.';
                }
            }
        }
    }

    static boolean moveSwan() {
        while (!sQ.isEmpty()) {
            int[] pos = sQ.poll();
            y = pos[0];
            x = pos[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (v_swan[ny][nx] != 0) {
                    continue;
                }
                v_swan[ny][nx] = 1;
                if (a[ny][nx] == '.') {
                    sQ.add(new int[] { ny, nx });
                } else if (a[ny][nx] == 'X') {
                    s_tempQ.add(new int[] { ny, nx });
                } else if (a[ny][nx] == 'L') {
                    return true;
                }
            }
        }
        return false;
    }
}
