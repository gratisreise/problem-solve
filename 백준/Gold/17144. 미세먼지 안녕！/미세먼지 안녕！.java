import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] board;
    static int topCleaner; // 위쪽 공기청정기의 행(row) 위치

    // 확산 시 사용하는 4방향
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) topCleaner = i - 1; // 마지막 -1의 바로 위가 top
            }
        }

        while (T-- > 0) {
            diffusion();
            purify();
        }

        System.out.println(calculateSum());
    }

    // 1. 미세먼지 확산 (임시 배열 사용)
    static void diffusion() {
        int[][] temp = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] <= 0) continue;

                int val = board[r][c] / 5;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] != -1) {
                        temp[nr][nc] += val;
                        cnt++;
                    }
                }
                board[r][c] -= val * cnt;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) board[i][j] += temp[i][j];
        }
    }

    // 2. 공기청정기 작동 (역방향 당기기)
    static void purify() {
        // 위쪽: 반시계 방향의 역순 (위 -> 오 -> 아래 -> 왼 순서로 당기기)
        operate(topCleaner, new int[]{-1, 0, 1, 0}, new int[]{0, 1, 0, -1});
        // 아래쪽: 시계 방향의 역순 (아래 -> 오 -> 위 -> 왼 순서로 당기기)
        operate(topCleaner + 1, new int[]{1, 0, -1, 0}, new int[]{0, 1, 0, -1});
    }



    static void operate(int cleanerY, int[] dy, int[] dx) {
        int y = cleanerY + dy[0]; // 공기청정기로 들어오는 첫 번째 칸
        int x = 0;
        int d = 0;

        while (true) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 한 바퀴 돌아 공기청정기 위치에 도달하면 종료
            if (ny == cleanerY && nx == 0) {
                board[y][x] = 0; // 공기청정기에서 나가는 깨끗한 공기
                break;
            }

            // 벽을 만나거나 정해진 영역을 벗어나면 방향 전환
            if (ny < 0 || ny >= R || nx < 0 || nx >= C ||
                (cleanerY <= topCleaner && ny > topCleaner) ||
                (cleanerY > topCleaner && ny <= topCleaner)) {
                d++;
                continue;
            }

            // 다음 칸(ny, nx)의 먼지를 현재 칸(y, x)으로 당겨옴
            board[y][x] = board[ny][nx];
            y = ny;
            x = nx;
        }
    }

    static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) sum += board[i][j];
            }
        }
        return sum;
    }
}