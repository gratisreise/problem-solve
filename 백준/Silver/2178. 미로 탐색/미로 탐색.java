import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                a[i][j] = c[j] - '0';
            }
        }
        //bfs 최단거리 방문배열
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (a[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        bw.write(String.valueOf(visited[n - 1][m - 1]) + '\n');
        bw.flush();
    }
}