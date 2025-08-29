import sys
from collections import deque
input = sys.stdin.readline
INF = sys.maxsize

# 이동 방향 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 불의 확산 BFS
def fire_bfs(fire_queue, fire_time):
    while fire_queue:
        y, x = fire_queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            # 범위 내이고, 벽이 아니며, 아직 불이 도달하지 않은 경우
            if 0 <= ny < R and 0 <= nx < C and grid[ny][nx] != '#' and fire_time[ny][nx] == INF:
                fire_time[ny][nx] = fire_time[y][x] + 1
                fire_queue.append((ny, nx))

# 지훈이의 이동 BFS
def jihoon_bfs(jihoon_queue, jihoon_time, fire_time):
    while jihoon_queue:
        y, x = jihoon_queue.popleft()
        # 가장자리에 도달하면 탈출 성공
        if y == 0 or y == R-1 or x == 0 or x == C-1:
            return jihoon_time[y][x] + 1  # 탈출 시간 반환
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            # 범위 내이고, 빈 칸이며, 아직 방문하지 않은 경우
            if (0 <= ny < R and 0 <= nx < C and grid[ny][nx] == '.' and 
                jihoon_time[ny][nx] == -1):
                # 불이 도달하기 전에 이동 가능
                if fire_time[ny][nx] > jihoon_time[y][x] + 1:
                    jihoon_time[ny][nx] = jihoon_time[y][x] + 1
                    jihoon_queue.append((ny, nx))
    return "IMPOSSIBLE"

# 입력 처리
R, C = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]

# 불과 지훈이의 BFS 준비
fire_queue = deque()        # 불의 위치 큐
jihoon_queue = deque()      # 지훈이의 위치 큐
fire_time = [[INF] * C for _ in range(R)]    # 불이 도달하는 시간
jihoon_time = [[-1] * C for _ in range(R)]   # 지훈이의 이동 시간

# 초기 위치 설정
for i in range(R):
    for j in range(C):
        if grid[i][j] == 'F':
            fire_queue.append((i, j))
            fire_time[i][j] = 0
        elif grid[i][j] == 'J':
            jihoon_queue.append((i, j))
            jihoon_time[i][j] = 0
            grid[i][j] = '.'  # 지훈이 위치를 빈 칸으로 변경

# 1. 불의 확산 처리
fire_bfs(fire_queue, fire_time)

# 2. 지훈이의 이동 처리
result = jihoon_bfs(jihoon_queue, jihoon_time, fire_time)

# 결과 출력
print(result)
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 지훈이가 미로에서 불을 피해 가장자리로 탈출하는 최소 시간 구하기.
* 조건:
    * 미로: R×C (1 ≤ R, C ≤ 1000).
    * 미로 값:
        * '.' (빈 칸, 이동 가능).
        * '#' (벽, 이동 불가).
        * 'J' (지훈이의 시작 위치).
        * 'F' (불의 시작 위치, 여러 개 가능).
    * 이동: 상하좌우, 1초 소요.
    * 불: 매 초 상하좌우로 확산 (벽 제외).
    * 지훈이: 불이 없는 빈 칸으로만 이동 가능, 불이 도달하기 전에 이동해야 함.
    * 탈출: 미로의 가장자리(첫 번째/마지막 행/열)에 도달.
* 출력:
    * 탈출 가능: 최소 시간 (초).
    * 불가능: "IMPOSSIBLE".
접근 아이디어
* BFS:
    * 두 개의 BFS 사용:
        1. 불의 확산: 각 칸에 불이 도달하는 시간 계산.
        2. 지훈이의 이동: 불이 도달하기 전에 이동 가능한 경로 탐색.
    * 불 BFS 먼저 수행하여 각 칸의 불 도착 시간 미리 계산.
    * 지훈이 BFS에서 불 도착 시간과 비교하며 이동.
* 상태 관리:
    * grid: 미로 상태.
    * fire_time: 각 칸에 불이 도달하는 시간.
    * jihoon_time: 지훈이의 이동 시간.
    * fire_queue, jihoon_queue: BFS 큐.
* 구현 전략:
    * 불 BFS로 모든 칸의 불 도착 시간 계산.
    * 지훈이 BFS로 가장자리 도달 시간 계산, 불 시간 고려.
    * 가장자리 도달 시 시간 반환, 실패 시 "IMPOSSIBLE".

1. 입력 처리
* input = sys.stdin.readline: 빠른 입력.
* INF = sys.maxsize: 불이 도달하지 않은 칸의 초기값.
* R, C: 미로 세로(R), 가로(C).
* grid: R×C 미로 입력.
* dy, dx: 4방향 이동 벡터.
2. 초기화
* fire_queue, jihoon_queue: 불과 지훈이의 BFS 큐.
* fire_time: 각 칸의 불 도착 시간, 초기값 INF.
* jihoon_time: 지훈이의 이동 시간, 초기값 -1 (미방문).
* 격자 순회:
    * grid[i][j] == 'F': fire_queue.append((i, j)), fire_time[i][j] = 0.
    * grid[i][j] == 'J': jihoon_queue.append((i, j)), jihoon_time[i][j] = 0, grid[i][j] = '.' (지훈이 위치를 빈 칸으로 변경).
3. 불의 확산 BFS
* fire_bfs(fire_queue, fire_time):
    * while fire_queue:
        * y, x = fire_queue.popleft(): 현재 불 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 내, 벽 아님(grid[ny][nx] != '#'), 불 미도달(fire_time[ny][nx] == INF):
                * fire_time[ny][nx] = fire_time[y][x] + 1: 불 도착 시간 기록.
                * fire_queue.append((ny, nx)): 다음 위치 추가.
4. 지훈이의 이동 BFS
* jihoon_bfs(jihoon_queue, jihoon_time, fire_time):
    * while jihoon_queue:
        * y, x = jihoon_queue.popleft(): 현재 지훈이 위치.
        * 가장자리 도달(y == 0 or y == R-1 or x == 0 or x == C-1):
            * return jihoon_time[y][x] + 1: 탈출 시간 반환 (가장자리 도착 후 1초 추가).
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 내, 빈 칸(grid[ny][nx] == '.'), 미방문(jihoon_time[ny][nx] == -1):
                * 불 도착 전 이동 가능(fire_time[ny][nx] > jihoon_time[y][x] + 1):
                    * jihoon_time[ny][nx] = jihoon_time[y][x] + 1: 이동 시간 기록.
                    * jihoon_queue.append((ny, nx)): 다음 위치 추가.
    * return "IMPOSSIBLE": 탈출 실패.
5. 실행 및 출력
* fire_bfs(fire_queue, fire_time): 불 확산 처리.
* result = jihoon_bfs(jihoon_queue, jihoon_time, fire_time): 지훈이 이동 처리.
* print(result): 결과 출력 (시간 또는 "IMPOSSIBLE").

문제 분석
* 문제: 백준 4179 "불!".
* 입력: R, C, R×C 미로.
* 출력: 최소 탈출 시간 또는 "IMPOSSIBLE".
* 조건: 불 확산과 지훈이 이동 동시 고려, 가장자리 탈출.

시간 복잡도
* 불 BFS: O(R * C) (각 칸 최대 1번 방문).
* 지훈이 BFS: O(R * C).
* 총합: O(R * C) (R, C ≤ 1000, ≈ 10^6), 1초 내 충분.

"""