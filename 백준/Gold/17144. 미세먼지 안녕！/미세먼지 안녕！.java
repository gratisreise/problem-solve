import java.io.*;
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

        //미세먼지 확산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] >= 5) {
                    int spread = a[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == -1) continue;
                        temp[ny][nx] += spread;
                        a[i][j] -= spread;
                    }
                }
            }
        }

        //확산된거 적용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] += temp[i][j];
            }
        }
    }
    // 공청기의 작동흐름을 저장
    public static ArrayList<Pair> chung(int sy, int sx, int[] dy, int[] dx) {
        ArrayList<Pair> v = new ArrayList<>();
        int cnt = 0;
        int y = sy;
        int x = sx;


        //한바퀴 돌려버리기
        while (true) {
            int ny = y + dy[cnt];
            int nx = x + dx[cnt];

            // 시작점으로 돌아왔으면 브레이크
            if (ny == sy && nx == sx) break;
            // 경계에 도달 했으면 방향바꿔주기
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                cnt = (cnt + 1) % 4; // 방향바꿔주기
                ny = y + dy[cnt];
                nx = x + dx[cnt];
            }

            // 방향이 바뀌면 다음좌표로 시작점이면 브레이크
            if (ny == sy && nx == sx) break;
            y = ny;
            x = nx;
            // 다음으로
            v.add(new Pair(ny, nx));
        }

        return v;
    }

    public static void go(ArrayList<Pair> v) {
        //미세먼지 이동
        for (int i = v.size() - 1; i > 0; i--) {
            int ny = v.get(i).f;
            int nx = v.get(i).s;
            a[ny][nx] = a[v.get(i - 1).f][v.get(i - 1).s];
        }
        //첫 좌표는 0
        a[v.get(0).f][v.get(0).s] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        // 위아래 구분하기 위한 flag
        boolean flag = true;
        a = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == -1) {
                    //공청기의 이동방향을 순차적으로 저장
                    if (flag) {
                        v1 = chung(i, j, dy1, dx1);
                        flag = false;
                    } else v2 = chung(i, j, dy2, dx2);
                }
            }
        }

        while (t-- > 0) {
            mise_go(dy1, dx1);
            go(v1);
            go(v2);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1) ret += a[i][j];
            }
        }

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
1. 미세먼지 확산
  1-1. 확산할 미세먼지의 양을 임시배열에 저장한다.
  1-2. 확산할 미세먼지의 양만큼 미세먼지를 빼준다.
  1-3. 임시배열에 저장된 먼지양을 더해준다.
2. 공청기 작동
  2-1. 공청기의 이동할 좌표를 list에 저장한다.
  2-2. t번 만큼 공청기의 이동방향으로 먼지를 이동시켜준다.
*/