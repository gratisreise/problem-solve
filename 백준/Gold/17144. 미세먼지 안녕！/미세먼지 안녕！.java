import java.util.*;
public class Main {
    static int n, m, t, ret;
    static int[][] a, temp;
    static ArrayList<Pair> v1, v2;
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};
    static class Pair {
        int f, s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public static void mise_go(int[] dy, int[] dx) {
        temp = new int[n + 1][m + 1];
        Queue<Pair> q = new LinkedList<>();

        //미세먼지 넣어줌
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1 && a[i][j] > 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        //먼지 확산
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int y = pair.f;
            int x = pair.s;
            int spread = a[y][x] / 5;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == -1) continue;

                temp[ny][nx] += spread;
                a[y][x] -= spread;
            }
        }

        //확산된거 적용
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
            int ny = v.get(i).f;
            int nx = v.get(i).s;
            a[ny][nx] = a[v.get(i - 1).f][v.get(i - 1).s];
        }
        a[v.get(0).f][v.get(0).s] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        boolean flag = true;
        a = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == -1) {
                    if (flag) {
                        v1 = chung(i, j, dy1, dx1);
                        flag = false;
                    } else v2 = chung(i, j, dy2, dx2);
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
}