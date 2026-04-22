import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 1. 사전순 d, l, r, u 설정
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] alp = {'d', 'l', 'r', 'u'};
        
        // 2. 불가능한 케이스 미리 컷
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        int curX = x, curY = y;
        
        // 3. 재귀 대신 k번 반복문 돌리기 (Greedy)
        for (int i = 0; i < k; i++) {
            boolean moved = false;
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                
                // 격자 범위 체크
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                
                // 남은 거리 계산 (맨해튼)
                int nextDist = Math.abs(nx - r) + Math.abs(ny - c);
                int remainSteps = k - (i + 1);
                
                // 가지치기 조건 (핵심!)
                if (nextDist <= remainSteps) {
                    sb.append(alp[d]);
                    curX = nx;
                    curY = ny;
                    moved = true;
                    break; // 사전순으로 가장 빠른 걸 찾았으니 다음 스텝(i+1)으로!
                }
            }
            if (!moved) return "impossible"; // 사실 위에서 이미 체크해서 여기 올 일은 없음
        }
        
        return sb.toString();
    }
}