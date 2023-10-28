import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m, t, y, x, ret;
    static int[][] a, temp;
    static ArrayList<Pair> v1, v2;

    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};

    public static void mise_go(int[] dy, int[] dx) {
        temp = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1 && a[i][j] > 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int y = pair.x;
            int x = pair.y;
            int spread = a[y][x] / 5;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == -1) continue;

                temp[ny][nx] += spread;
                a[y][x] -= spread;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] += temp[i][j];
            }
        }
    }

    public static ArrayList<Pair> chung(int sy, int sx, int[] dy, int[] dx) {
        ArrayList<Pair> v = new ArrayList<>();
        int cnt = 0;
        int y = sy;
        int x = sx;

        while (true) {
            int ny = y + dy[cnt];
            int nx = x + dx[cnt];

            if (ny == sy && nx == sx) break;
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                cnt = (cnt + 1) % 4;
                ny = y + dy[cnt];
                nx = x + dx[cnt];
            }

            if (ny == sy && nx == sx) break;
            y = ny;
            x = nx;
            v.add(new Pair(ny, nx));
        }

        return v;
    }

    public static void go(ArrayList<Pair> v) {
        for (int i = v.size() - 1; i > 0; i--) {
            int ny = v.get(i).x;
            int nx = v.get(i).y;
            a[ny][nx] = a[v.get(i - 1).x][v.get(i - 1).y];
        }

        a[v.get(0).x][v.get(0).y] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        t = scanner.nextInt();
        boolean flag = true;
        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                if (a[i][j] == -1) {
                    if (flag) {
                        v1 = chung(i, j, dy1, dx1);
                        flag = false;
                    } else {
                        v2 = chung(i, j, dy2, dx2);
                    }
                }
            }
        }

        while (t > 0) {
            mise_go(dy1, dx1);
            go(v1);
            go(v2);
            t--;
        }

        ret = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1) {
                    ret += a[i][j];
                }
            }
        }

        System.out.println(ret);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
