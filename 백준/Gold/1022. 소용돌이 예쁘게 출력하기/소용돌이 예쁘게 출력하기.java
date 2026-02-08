import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] board = new int[r2 - r1 + 1][c2 - c1 + 1];
        int max = 0;

        // 1. 해당 범위의 값들을 계산하고 최댓값 찾기
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i - r1][j - c1] = getValue(i, j);
                max = Math.max(max, board[i - r1][j - c1]);
            }
        }

        // 2. 최댓값의 자릿수 구하기
        int maxLength = String.valueOf(max).length();

        // 3. 정렬된 형식으로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                sb.append(String.format("%" + maxLength + "d ", board[i][j]));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 좌표 (r, c)에 위치한 소용돌이 숫자를 계산하는 함수
    private static int getValue(int r, int c) {
        int d = Math.max(Math.abs(r), Math.abs(c)); // 현재 위치가 속한 정사각형 껍질 번호
        int last = (2 * d + 1) * (2 * d + 1); // 해당 껍질의 가장 큰 값 (우측 하단 끝값)

        if (r == d) return last - (d - c); // 하단 변
        if (c == -d) return last - 2 * d - (d - r); // 좌측 변
        if (r == -d) return last - 4 * d - (c + d); // 상단 변
        return last - 6 * d - (r + d); // 우측 변
    }
}