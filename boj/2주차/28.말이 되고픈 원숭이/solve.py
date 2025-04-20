from collections import deque

k = int(input())  # 나이트 이동 횟수 제한
w, h = map(int, input().split())  # 격자 크기
grid = [list(map(int, input().split())) for _ in range(h)]  # 격자 입력

# 상하좌우 이동 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 나이트 이동 방향 (8방향)
knight_dx = [-2, -1, 1, 2, 2, 1, -1, -2]
knight_dy = [1, 2, 2, 1, -1, -2, -2, -1]

# 3차원 방문 배열: [k][x][y]
visited = [[[False] * w for _ in range(h)] for _ in range(k + 1)]

q = deque()
q.append((0, 0, k, 0))  # (x, y, 남은 K, 이동 횟수)
visited[k][0][0] = True  # 시작 지점 방문 처리

answer = -1

while q:
    x, y, remain_k, moves = q.popleft()  # 현재 상태
    
    # 목표 지점 도달
    if x == h - 1 and y == w - 1:
        answer = moves
        break
    
    # 일반 이동 (상하좌우)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w:
            if grid[nx][ny] == 0 and not visited[remain_k][nx][ny]:
                visited[remain_k][nx][ny] = True
                q.append((nx, ny, remain_k, moves + 1))
    
    # 나이트 이동 (남은 기회 있음)
    if remain_k > 0:
        for i in range(8):
            nx = x + knight_dx[i]
            ny = y + knight_dy[i]
            if 0 <= nx < h and 0 <= ny < w:
                if grid[nx][ny] == 0 and not visited[remain_k - 1][nx][ny]:
                    visited[remain_k - 1][nx][ny] = True
                    q.append((nx, ny, remain_k - 1, moves + 1))

print(answer)  # 결과 출력
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 원숭이가 (0,0)에서 (H-1,W-1)까지 이동하는 최소 이동 횟수 구하기.
* 조건:
    * 격자: H×W (1 ≤ H, W ≤ 200).
    * 격자 값: 0(이동 가능), 1(장애물).
    * 이동:
        * 일반 이동: 상하좌우 (1회 이동당 1카운트).
        * 나이트 이동: 체스 나이트의 8방향 (1회 이동당 1카운트, 최대 K번, 0 ≤ K ≤ 30).
    * 시작: (0,0).
    * 목표: (H-1,W-1).
* 출력: 최소 이동 횟수 (도달 불가 시 -1).
접근 아이디어
* BFS:
    * 최단 경로 문제로 BFS 적합.
    * 상태: 위치(x,y)와 남은 나이트 이동 횟수(K).
    * 3차원 방문 배열로 각 상태 관리.
* 상태 관리:
    * grid: 격자 상태.
    * visited: [K][x][y]로 나이트 이동 횟수와 위치별 방문 여부.
    * q: BFS 큐, (x,y,남은 K,이동 횟수) 저장.
* 구현 전략:
    * 시작점에서 상하좌우 이동과 나이트 이동(남은 K > 0) 탐색.
    * 목표 도달 시 이동 횟수 반환.
    * 도달 불가 시 -1.
1. 입력 처리
* k: 나이트 이동 횟수 제한.
* w, h: 격자 가로(W), 세로(H).
* grid: H×W 격자 입력 (0: 이동 가능, 1: 장애물).
* dx, dy: 상하좌우 이동 방향.
* knight_dx, knight_dy: 나이트의 8방향 이동.
* visited: 3차원 방문 배열 [K+1][H][W], 초기값 False.
2. BFS 초기화
* q = deque(): BFS 큐.
* q.append((0, 0, k, 0)): 시작점 (0,0), 초기 K, 이동 횟수 0.
* visited[k][0][0] = True: 시작점 방문 처리.
* answer = -1: 결과 초기값 (도달 불가 시 -1).
3. BFS
* while q:
    * x, y, remain_k, moves = q.popleft(): 현재 상태.
    * if x == h - 1 and y == w - 1: 목표 도달:
        * answer = moves, 종료.
    * 일반 이동:
        * 4방향 탐색:
            * nx, ny: 다음 위치.
            * 범위 내, grid[nx][ny] == 0, 미방문:
                * visited[remain_k][nx][ny] = True.
                * q.append((nx, ny, remain_k, moves + 1)).
    * 나이트 이동:
        * if remain_k > 0:
            * 8방향 탐색:
                * nx, ny: 다음 위치.
                * 범위 내, grid[nx][ny] == 0, 미방문:
                    * visited[remain_k - 1][nx][ny] = True.
                    * q.append((nx, ny, remain_k - 1, moves + 1)).
4. 출력
* print(answer): 최소 이동 횟수 출력 (-1 if unreachable).

문제 분석
* 문제: 백준 1600 "말이 되고픈 원숭이".
* 입력: K, W, H, H×W 격자.
* 출력: 최소 이동 횟수 (-1 if unreachable).
* 조건: 상하좌우 + 나이트 이동(K번 제한), 장애물 피하기.

시간 복잡도
* 상태: (x, y, remain_k) → O(H * W * K).
* 각 상태에서 이동: 4(일반) + 8(나이트) = 12.
* BFS: O(H * W * K * 12) (H, W ≤ 200, K ≤ 30, ≈ 200 * 200 * 30 * 12 ≈ 1.44×10^7), 1초 내 충분.
"""