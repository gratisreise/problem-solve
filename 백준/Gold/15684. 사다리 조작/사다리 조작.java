import java.util.Scanner;

public class Main {
    static int n, m, h, a, b;
    static int ret = Integer.MAX_VALUE; // 최대에서 최소
    static int[][] visited; // 가로선 있는지 표현

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        visited = new int[35][35];

        while (m-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            visited[a][b] = 1;
        }

        go(1, 0); // 가로선 추가하는 함수

        // 가능한 경우 없으면 -1, 아니면 ret 출력
        System.out.println((ret == Integer.MAX_VALUE) ? -1 : ret);
    }

    static boolean check() { // 가로선 추가할 때마다 자기 자신으로 오나 확인
        for (int i = 1; i <= n; i++) { // 각 세로선에 대해서
            int start = i; // start가 자기 자신이 되는지 확인
            for (int j = 1; j <= h; j++) { // 가로선에 의한 결과 확인
                if (visited[j][start] == 1) {
                    start++; // 현재 점에 있으면 오른쪽으로
                } else if (visited[j][start - 1] == 1) {
                    start--; // 이전 세로선에 있으면 이전으로
                }
            }
            if (start != i) return false; // 같지 않으면 false
        }
        return true;
    }

    // (시작점, 가로선 갯수)
    static void go(int here, int cnt) {
        if (cnt > 3 || cnt >= ret) return;
        if (check()) {
            ret = Math.min(ret, cnt);
            return;
        }
        for (int i = here; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                // 가로선이 이미 있는 경우 패스
                if (visited[i][j] == 1 || visited[i][j - 1] == 1 || visited[i][j + 1] == 1) continue;
                // 가로선이 없으면 가로선을 그리고 다음으로 이동
                visited[i][j] = 1;
                go(i, cnt + 1);
                visited[i][j] = 0; // 원상복구
            }
        }
    }
}
