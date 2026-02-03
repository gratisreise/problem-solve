import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (check(i, 0, true)) count++;  // 가로 방향 체크
            if (check(0, i, false)) count++; // 세로 방향 체크
        }

        System.out.println(count);
    }

    // isRow가 true면 가로(행) 체크, false면 세로(열) 체크
    public static boolean check(int r, int c, boolean isRow) {
        int[] line = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            line[i] = isRow ? map[r][i] : map[i][c];
        }

        for (int i = 0; i < N - 1; i++) {
            // 1. 높이가 같은 경우
            if (line[i] == line[i + 1]) continue;

            // 2. 높이 차이가 1보다 크면 실패
            if (Math.abs(line[i] - line[i + 1]) > 1) return false;

            // 3. 내리막길 (현재 > 다음)
            if (line[i] - line[i + 1] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    // 범위를 벗어나거나, 높이가 다르거나, 이미 경사로가 있는 경우
                    if (j >= N || line[j] != line[i + 1] || visited[j]) return false;
                    visited[j] = true;
                }
            } 
            // 4. 오르막길 (현재 < 다음)
            else if (line[i] - line[i + 1] == -1) {
                for (int j = i; j > i - L; j--) {
                    // 범위를 벗어나거나, 높이가 다르거나, 이미 경사로가 있는 경우
                    if (j < 0 || line[j] != line[i] || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}