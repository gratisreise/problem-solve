import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 19;
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 검사할 방향: 오른쪽, 아래, 대각선 아래오른쪽, 대각선 위오른쪽
        int[] dx = {0, 1, 1, -1};
        int[] dy = {1, 0, 1, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int color = board[i][j];
                if (color == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int px = i - dx[dir];
                    int py = j - dy[dir];

                    // 이전 칸이 같은 색이면 이미 그 방향에서 검사한 상태이므로 건너뜀 (중복 방지)
                    if (px >= 0 && px < N && py >= 0 && py < N && board[px][py] == color) {
                        continue;
                    }

                    int count = 1;
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    while (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == color) {
                        count++;
                        nx += dx[dir];
                        ny += dy[dir];
                    }

                    if (count == 5) {
                        // 출력: 승자, 시작 좌표(행 열) 1-index
                        System.out.println(color);
                        System.out.println((i+1) + " " + (j+1));
                        return;
                    }
                }
            }
        }

        System.out.println(0); // 승부 결정 안남
    }
}
