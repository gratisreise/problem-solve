import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);
        System.out.println(maxBlock);
    }

    // 5번 이동하는 모든 경우의 수를 탐색 (DFS)
    static void dfs(int[][] board, int count) {
        if (count == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxBlock = Math.max(maxBlock, board[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(move(board, i), count + 1);
        }
    }

    // 보드를 특정 방향으로 밀기
    static int[][] move(int[][] board, int dir) {
        int[][] nextBoard = new int[N][N];
        
        // 0: 상, 1: 하, 2: 좌, 3: 우
        if (dir == 0) { // 위로 밀기
            for (int j = 0; j < N; j++) {
                int index = 0;
                int lastValue = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) {
                        if (lastValue == board[i][j]) {
                            nextBoard[index - 1][j] = lastValue * 2;
                            lastValue = 0; // 한 번 합쳐진 것은 다시 합쳐질 수 없음
                        } else {
                            lastValue = board[i][j];
                            nextBoard[index][j] = lastValue;
                            index++;
                        }
                    }
                }
            }
        } else if (dir == 1) { // 아래로 밀기
            for (int j = 0; j < N; j++) {
                int index = N - 1;
                int lastValue = 0;
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        if (lastValue == board[i][j]) {
                            nextBoard[index + 1][j] = lastValue * 2;
                            lastValue = 0;
                        } else {
                            lastValue = board[i][j];
                            nextBoard[index][j] = lastValue;
                            index--;
                        }
                    }
                }
            }
        } else if (dir == 2) { // 왼쪽으로 밀기
            for (int i = 0; i < N; i++) {
                int index = 0;
                int lastValue = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        if (lastValue == board[i][j]) {
                            nextBoard[i][index - 1] = lastValue * 2;
                            lastValue = 0;
                        } else {
                            lastValue = board[i][j];
                            nextBoard[i][index] = lastValue;
                            index++;
                        }
                    }
                }
            }
        } else { // 오른쪽으로 밀기
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int lastValue = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (lastValue == board[i][j]) {
                            nextBoard[i][index + 1] = lastValue * 2;
                            lastValue = 0;
                        } else {
                            lastValue = board[i][j];
                            nextBoard[i][index] = lastValue;
                            index--;
                        }
                    }
                }
            }
        }
        return nextBoard;
    }
}