import java.util.*;

class Solution {
    // 구조물 정보를 저장할 클래스
    static class Node {
        boolean gi; // 기둥 존재 여부
        boolean bo; // 보 존재 여부
        Node() {
            this.gi = false;
            this.bo = false;
        }
    }

    // 전체 보드의 유효성을 검사하는 함수
    public boolean check(Node[][] board, int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                // 1. 기둥 검사
                if (board[x][y].gi) {
                    // 조건: 바닥(0) or 아래에 기둥 or 현재 위치에 보 or 왼쪽 위치에 보
                    if (!(y == 0 || (y > 0 && board[x][y - 1].gi) || 
                          board[x][y].bo || (x > 0 && board[x - 1][y].bo))) {
                        return false;
                    }
                }
                // 2. 보 검사
                if (board[x][y].bo) {
                    // 조건: 왼쪽 아래에 기둥 or 오른쪽 아래에 기둥 or 양옆에 보
                    if (!((y > 0 && board[x][y - 1].gi) || (y > 0 && x < n && board[x + 1][y - 1].gi) || 
                          (x > 0 && x < n && board[x - 1][y].bo && board[x + 1][y].bo))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        // n x n 격자이지만 좌표는 0부터 n까지이므로 크기는 n+1
        Node[][] board = new Node[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                board[i][j] = new Node();
            }
        }

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];   // 0: 기둥, 1: 보
            int action = frame[3]; // 0: 삭제, 1: 설치

            if (type == 0) { // 기둥
                if (action == 1) {
                    board[x][y].gi = true;
                    if (!check(board, n)) board[x][y].gi = false;
                } else {
                    board[x][y].gi = false;
                    if (!check(board, n)) board[x][y].gi = true;
                }
            } else { // 보
                if (action == 1) {
                    board[x][y].bo = true;
                    if (!check(board, n)) board[x][y].bo = false;
                } else {
                    board[x][y].bo = false;
                    if (!check(board, n)) board[x][y].bo = true;
                }
            }
        }

        // 결과물 리스트 생성
        List<int[]> result = new ArrayList<>();
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (board[x][y].gi) result.add(new int[]{x, y, 0});
                if (board[x][y].bo) result.add(new int[]{x, y, 1});
            }
        }

        // 정렬: x 오름차 -> y 오름차 -> 기둥(0) 우선
        Collections.sort(result, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // 리스트를 배열로 변환
        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}