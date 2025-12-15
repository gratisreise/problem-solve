import java.io.*;
import java.util.*;

public class Main {
    // 상하좌우 이동 (dy, dx는 그대로 사용)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 폭탄을 터뜨리는 함수. (y, x)와 인접 4방향을 '.'으로 바꿉니다.
    static char[][] boom(char[][] board, int y, int x) {
        int r = board.length;
        int c = board[0].length;

        // 새로운 격자 생성 (깊은 복사)
        char[][] nextBoard = new char[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(board[i], 0, nextBoard[i], 0, c);
        }

        // 폭탄이 터지는 위치와 인접 4칸을 빈 칸으로 만듭니다.
        nextBoard[y][x] = '.';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
                // 이미 빈 칸이 된 곳에 폭탄이 있었다고 해도 연쇄 폭발은 없으므로 그냥 덮어씁니다.
                nextBoard[ny][nx] = '.';
            }
        }
        return nextBoard;
    }

    // 격자 상태를 출력하는 함수
    static void printBoard(char[][] board) {
        StringBuilder ret = new StringBuilder();
        for (char[] row : board) {
            for (char cell : row) {
                ret.append(cell);
            }
            ret.append('\n');
        }
        System.out.println(ret);
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(in.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] initialBoard = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = in.readLine();
            for (int j = 0; j < c; j++) {
                initialBoard[i][j] = s.charAt(j);
            }
        }

        // N이 1일 때: 초기 상태
        if (n == 1) {
            printBoard(initialBoard);
            return;
        }

        // N이 짝수일 때: 모든 칸에 폭탄 (t=2, 4, 6, ...)
        if (n % 2 == 0) {
            char[][] fullBoard = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(fullBoard[i], 'O');
            }
            printBoard(fullBoard);
            return;
        }

        // N이 홀수일 때 (N=3, 5, 7, ... 패턴 이용)

        // board1: T=3 일 때의 상태 (초기 폭탄이 터진 상태)
        // initialBoard에서 'O'인 폭탄이 터집니다.
        char[][] board1 = new char[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(board1[i], 'O'); // 일단 모두 'O'로 채운 후, 터질 폭탄 위치를 파악

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                // 초기 폭탄 위치와 인접 4칸이 터져서 빈칸이 됩니다.
                if(initialBoard[i][j] == 'O'){
                    board1[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
                            board1[ny][nx] = '.';
                        }
                    }
                }
            }
        }

        // board2: T=5 일 때의 상태 (T=2에 설치된 폭탄이 터진 상태)
        // board1 상태에서, T=2에 설치된 폭탄('O')이 터집니다.
        // T=2에 설치된 폭탄은 initialBoard에서 '.'이었던 위치입니다.
        char[][] board2 = new char[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(board2[i], 'O'); // 일단 모두 'O'로 채운 후, 터질 폭탄 위치를 파악

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                // T=2에 설치된 폭탄 위치 (initialBoard가 '.'이었던 위치)와 인접 4칸이 터집니다.
                if(board1[i][j] == 'O' && initialBoard[i][j] == '.'){ // T=2에 설치되어 T=5에 터질 폭탄
                    board2[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
                            board2[ny][nx] = '.';
                        }
                    }
                }
            }
        }


        // N % 4에 따른 출력
        if (n % 4 == 3) {
            // N = 3, 7, 11, ... (T=3의 상태와 동일)
            printBoard(board1);
        } else { // N % 4 == 1 (N = 5, 9, 13, ...)
            // N = 5, 9, 13, ... (T=5의 상태와 동일)
            printBoard(board2);
        }
    }
}