import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static class State {
        int ry, rx, by, bx, cnt;
        State(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry; this.rx = rx;
            this.by = by; this.bx = bx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int sry = 0, srx = 0, sby = 0, sbx = 0;

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') { sry = i; srx = j; }
                else if (board[i][j] == 'B') { sby = i; sbx = j; }
            }
        }

        System.out.println(bfs(sry, srx, sby, sbx));
    }

    static int bfs(int sry, int srx, int sby, int sbx) {
        Queue<State> q = new ArrayDeque<>();
        q.add(new State(sry, srx, sby, sbx, 0));
        visited[sry][srx][sby][sbx] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            // 10번 이상 기울였다면 실패 (BFS이므로 이후 탐색은 모두 10번 초과임)
            if(cur.cnt >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                // 1. 빨간 구슬 이동
                int nry = cur.ry, nrx = cur.rx;
                while (board[nry + dy[i]][nrx + dx[i]] != '#') {
                    nry += dy[i]; nrx += dx[i];
                    if (board[nry][nrx] == 'O') break;
                }

                // 2. 파란 구슬 이동
                int nby = cur.by, nbx = cur.bx;
                while (board[nby + dy[i]][nbx + dx[i]] != '#') {
                    nby += dy[i]; nbx += dx[i];
                    if (board[nby][nbx] == 'O') break;
                }

                // 3. 실패 조건: 파란 구슬이 빠지면 이번 방향은 무효
                if (board[nby][nbx] == 'O') continue;

                // 4. 성공 조건: 빨간 구슬만 빠지면 현재 횟수 + 1이 정답
                if (board[nry][nrx] == 'O') return cur.cnt + 1;

                // 5. 겹쳤을 때 처리: 이동 거리가 먼 쪽을 한 칸 뒤로
                if (nry == nby && nrx == nbx) {
                    int rDist = Math.abs(nry - cur.ry) + Math.abs(nrx - cur.rx);
                    int bDist = Math.abs(nby - cur.by) + Math.abs(nbx - cur.bx);
                    if (rDist > bDist) { nry -= dy[i]; nrx -= dx[i]; }
                    else { nby -= dy[i]; nbx -= dx[i]; }
                }

                // 6. 처음 가보는 상태라면 큐에 삽입
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.add(new State(nry, nrx, nby, nbx, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}