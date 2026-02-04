import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;
        int dir = 0; // 0: 동, 1: 남, 2: 서, 3: 북

        // 방향 이동 벡터 (동, 남, 서, 북)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (cmd.equals("TURN")) {
                if (value == 0) {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
            } 
            else if (cmd.equals("MOVE")) {
                x += dx[dir] * value;
                y += dy[dir] * value;

                // 범위 체크
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
