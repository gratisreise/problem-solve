import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n, m, ret = 1_000_000_000;
    static int[][] a, temp;
    static List<Pair> v = new ArrayList<>();
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void extendCCTV(int here, int dir, List<Pair> change) {
        int y = v.get(here).first;
        int x = v.get(here).second;

        if (a[y][x] == 1) {
            while (true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6) {
                    if (a[ny][nx] == 0) {
                        a[ny][nx] = 8;
                        change.add(new Pair(ny, nx));
                    }
                    y = ny;
                    x = nx;
                } else {
                    break;
                }
            }
        } else if (a[y][x] == 2) {
            for (int i = 0; i <= 2; i += 2) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6) {
                        if (a[ny][nx] == 0) {
                            a[ny][nx] = 8;
                            change.add(new Pair(ny, nx));
                        }
                        _y = ny;
                        _x = nx;
                    } else {
                        break;
                    }
                }
            }
        } else if (a[y][x] == 3) {
            for (int i = 0; i < 2; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6) {
                        if (a[ny][nx] == 0) {
                            a[ny][nx] = 8;
                            change.add(new Pair(ny, nx));
                        }
                        _y = ny;
                        _x = nx;
                    } else {
                        break;
                    }
                }
            }
        } else if (a[y][x] == 4) {
            for (int i = 0; i < 3; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6) {
                        if (a[ny][nx] == 0) {
                            a[ny][nx] = 8;
                            change.add(new Pair(ny, nx));
                        }
                        _y = ny;
                        _x = nx;
                    } else {
                        break;
                    }
                }
            }
        } else if (a[y][x] == 5) {
            for (int i = 0; i < 4; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] != 6) {
                        if (a[ny][nx] == 0) {
                            a[ny][nx] = 8;
                            change.add(new Pair(ny, nx));
                        }
                        _y = ny;
                        _x = nx;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    static void dfs(int here) {
        if (here == v.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ret = Math.min(cnt, ret);
            return;
        }
        for (int k = 0; k < 4; k++) {
            List<Pair> change = new ArrayList<>();
            extendCCTV(here, k, change);
            dfs(here + 1);
            for (Pair b : change) {
                a[b.first][b.second] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                if (a[i][j] != 6 && a[i][j] != 0) {
                    v.add(new Pair(i, j));
                }
            }
        }
        dfs(0);
        System.out.println(ret);
    }
}
