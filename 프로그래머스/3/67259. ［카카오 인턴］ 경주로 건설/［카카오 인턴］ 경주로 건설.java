import java.util.*;

class Node {
    int y, x, dir, cost;

    Node(int y, int x, int dir, int cost) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    // 상(0), 하(1), 좌(2), 우(3) 방향 설정
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][][] dp;

    public int solution(int[][] board) {
        int n = board.length;
        // dp[y][x][dir]: (y, x)에 dir 방향으로 들어왔을 때의 최소 비용
        dp = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> q = new LinkedList<>();

        // 1. 시작점 (0, 0) 처리
        // 처음 시작할 때는 방향이 없으므로, 네 방향 모두 가능성을 열어두거나
        // 아래(1)와 오른쪽(3)만 먼저 큐에 넣고 시작합니다.
        if (board[0][1] == 0) {
            dp[0][1][3] = 100;
            q.add(new Node(0, 1, 3, 100));
        }
        if (board[1][0] == 0) {
            dp[1][0][1] = 100;
            q.add(new Node(1, 0, 1, 100));
        }

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                // 범위 및 벽 체크
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1) continue;

                // 3. 비용 계산 (직선 100, 코너 500)
                int nextCost = curr.cost + 100;
                if (curr.dir != i) {
                    nextCost += 500; // 방향이 달라지면 코너 비용 추가
                }

                // 4. 최저가 갱신 및 큐 삽입
                // 같은 비용이더라도 다른 방향에서 오는 가능성을 위해 <= 를 사용하기도 함
                if (nextCost <= dp[ny][nx][i]) {
                    dp[ny][nx][i] = nextCost;
                    q.add(new Node(ny, nx, i, nextCost));
                }
            }
        }

        // 5. 목적지 (n-1, n-1)에 도착한 4개 방향 중 최솟값 찾기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[n - 1][n - 1][i]);
        }

        return answer;
    }
}