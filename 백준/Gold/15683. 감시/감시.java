import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0}; // 0:상, 1:우, 2:하, 3:좌
    static int[] dx = {0, 1, 0, -1};
    static int ret = 70;

    // 각 CCTV 타입별 초기 방향 (문제의 번호와 매칭되게 수정)
    static int[][] cctvDirs = {
        {},
        {1},          // 1번: 우
        {1, 3},       // 2번: 좌우
        {0, 1},       // 3번: 상우
        {0, 1, 3},    // 4번: 좌상우 (문제 설명에 맞춰 조정)
        {0, 1, 2, 3}  // 5번: 상하좌우
    };

    static int n, m;

    static class Point {
        int y, x, type;
        Point(int y, int x, int type) {
            this.y = y; this.x = x; this.type = type;
        }
    }

    static List<Point> cctvList = new ArrayList<>();
    static int[][] originBoard;

    // 회전 함수 (size만큼 90도 회전)
    static int[] rotate(int[] baseDir, int size) {
        int[] temp = new int[baseDir.length];
        for (int i = 0; i < baseDir.length; i++) {
            temp[i] = (baseDir[i] + size) % 4;
        }
        return temp;
    }

    // [핵심 변경!] Map 대신 index를 사용하여 순차적으로 결정
    static void go(int index, int[][] board) {
        // 모든 CCTV의 방향을 다 결정했다면?
        if (index == cctvList.size()) {
            int cnt = getBlindSpot(board);
            ret = Math.min(ret, cnt);
            return;
        }

        Point curr = cctvList.get(index);

        // 해당 CCTV의 방향을 4번 회전시켜보며 재귀 호출
        for (int d = 0; d < 4; d++) {
            int[][] nextBoard = copyBoard(board); // 현재 보드 상태 복사
            int[] rotatedDir = rotate(cctvDirs[curr.type], d);

            // 칠하기
            fill(nextBoard, curr, rotatedDir);

            // 다음 CCTV로 넘어가기 (index + 1)
            go(index + 1, nextBoard);

            // 5번 CCTV는 회전이 의미 없으므로 한 번만 수행하고 break (최적화)
            if (curr.type == 5) break;
            // 2번 CCTV는 2번만 회전해도 충분 (선택사항)
            if (curr.type == 2 && d == 1) break;
        }
    }

    static void fill(int[][] board, Point p, int[] dirs) {
        for (int direction : dirs) {
            int y = p.y;
            int x = p.x;
            while (true) {
                int ny = y + dy[direction];
                int nx = x + dx[direction];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 6) break;
                if (board[ny][nx] == 0) board[ny][nx] = 7; // 감시 구역은 7로 표시
                y = ny; x = nx;
            }
        }
    }

    static int[][] copyBoard(int[][] board) {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) res[i] = board[i].clone();
        return res;
    }

    static int getBlindSpot(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                originBoard[i][j] = Integer.parseInt(st.nextToken());
                if (originBoard[i][j] >= 1 && originBoard[i][j] <= 5) {
                    cctvList.add(new Point(i, j, originBoard[i][j]));
                }
            }
        }

        go(0, originBoard);
        System.out.println(ret);
    }
}