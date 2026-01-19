import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    // 빙산 좌표를 y*m+x 형태로 저장할 리스트
    static List<Integer> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    points.add(i * m + j); // 2차원 좌표를 1차원으로 변환하여 저장
                }
            }
        }

        int years = 0;
        while (true) {
            if (points.isEmpty()) { // 빙산이 다 녹을 때까지 분리 안 됨
                System.out.println(0);
                break;
            }

            if (isSplit()) { // 1. 현재 빙산 좌표들로만 분리 여부 확인
                System.out.println(years);
                break;
            }

            meltIce(); // 2. 빙산 녹이기 (points 리스트 갱신)
            years++;
        }
    }

    // 빙산이 분리되었는지 확인 (points에 있는 좌표들만 활용)
    static boolean isSplit() {
        if (points.isEmpty()) return false;

        boolean[][] visited = new boolean[n][m];
        Queue<Integer> q = new ArrayDeque<>();

        // 첫 번째 빙산부터 시작
        int first = points.get(0);
        q.offer(first);
        visited[first / m][first % m] = true;

        int connectedCount = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            int y = curr / m;
            int x = curr % m;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (board[ny][nx] > 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(ny * m + nx);
                        connectedCount++;
                    }
                }
            }
        }
        // 연결된 빙산 개수가 전체 리스트 개수와 다르면 분리된 것!
        return connectedCount != points.size();
    }

    static void meltIce() {
        // 이번 턴에 얼마나 녹을지 저장 (빙산 좌표 수만큼만 생성)
        int[] meltAmount = new int[points.size()];

        for (int i = 0; i < points.size(); i++) {
            int pos = points.get(i);
            int y = pos / m;
            int x = pos % m;

            int sea = 0;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (board[ny][nx] == 0) sea++;
            }
            meltAmount[i] = sea;
        }

        // 실제로 녹이고, 살아남은 빙산만 다시 리스트 구성
        List<Integer> nextPoints = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            int pos = points.get(i);
            int y = pos / m;
            int x = pos % m;

            board[y][x] = Math.max(0, board[y][x] - meltAmount[i]);
            if (board[y][x] > 0) {
                nextPoints.add(pos);
            }
        }
        points = nextPoints; // 리스트 교체
    }
}