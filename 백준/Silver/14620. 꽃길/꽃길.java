import java.util.Scanner;

public class Main {
    static int n;
    static int ret = 1000000000; // 최소에서 최대
    static int[][] p; // 꽃
    static int[][] v; // 꽃심은 것 확인
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = new int[n][n];
        v = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = scanner.nextInt();
            }
        }

        flower(0, 0);
        System.out.println(ret);
    }

    static boolean check(int y, int x) { // 꽃 심어도 되는지 확인
        if (v[y][x] != 0) return false; // 겹치면 안됨
        for (int i = 0; i < 4; i++) { // 상하좌우 체크
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (v[ny][nx] != 0) return false; // 겹치면 안됨
        }
        return true; // 안 겹치면 괜찮음
    }

    static int setFlower(int y, int x) { // 꽃의 땅값을 합산
        v[y][x] = 1; // 땅에 꽃잎 자리 칠하기
        int s = p[y][x]; // 땅값 합산
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            v[ny][nx] = 1;
            s += p[ny][nx];
        }
        return s;
    }

    static void eraseFlower(int y, int x) { // 원상복구용 방문 지우기
        v[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            v[ny][nx] = 0;
        }
    }

    static void flower(int cnt, int hap) {
        if (cnt == 3) {
            ret = Math.min(ret, hap);
            return;
        }
        // 어차피 화단 끝은 씨앗을 못 심으니 애초에 제거
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (check(i, j)) { // 자리 확인해서 가능하면
                    // 다음으로
                    flower(cnt + 1, hap + setFlower(i, j));
                    // 원상복구
                    eraseFlower(i, j);
                }
            }
        }
    }
}
