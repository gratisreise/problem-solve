from collections import deque
import sys

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

문제 이해
입력:
첫 줄: R, C (미로의 행과 열, 1 ≤ R, C ≤ 1000).
다음 R줄: 미로 상태.
#: 벽 (통과 불가).
.: 지나갈 수 있는 공간.
J: 지훈이의 초기 위치 (1개).
F: 불의 초기 위치 (0개 이상).
조건:
지훈이와 불은 매 분 상하좌우로 이동.
불은 각 위치에서 네 방향으로 확산.
지훈이는 미로의 가장자리에서 탈출 가능.
벽은 지훈이와 불 모두 통과 불가.
출력:
탈출 불가능: "IMPOSSIBLE".
탈출 가능: 가장 빠른 탈출 시간 (정수).
해결 접근법
BFS 활용: 지훈이와 불의 이동을 각각 BFS로 시뮬레이션.
불의 확산 먼저 처리: 각 칸에 불이 도달하는 시간을 미리 계산.
지훈이의 이동: 불이 도달하기 전에 이동하며, 가장자리에 도달하면 탈출 시간 반환.
시간 복잡도: 미로 크기가 최대 1000×1000이므로, O(R * C)로 처리해야 1초 내 해결 가능.


코드 설명
1. 입력 처리
R, C: 미로의 크기 입력.
grid: 미로 상태를 2D 리스트로 저장.
2. 불의 확산 BFS (fire_bfs)
fire_queue: 불의 현재 위치를 저장.
fire_time: 각 칸에 불이 도달하는 시간을 기록 (초기값 INF).
불이 상하좌우로 퍼지며, 벽이 아닌 칸에 대해 도달 시간을 갱신.
3. 지훈이의 이동 BFS (jihoon_bfs)
jihoon_queue: 지훈이의 현재 위치를 저장.
jihoon_time: 지훈이의 이동 시간을 기록 (초기값 -1).
이동 조건:
범위 내이고, 빈 칸이며, 아직 방문하지 않음.
불이 도달하기 전 (fire_time[ny][nx] > jihoon_time[y][x] + 1).
가장자리 도달 시 탈출 시간 반환, 불가능 시 "IMPOSSIBLE" 반환.
4. 메인 로직
초기 위치 설정: 불과 지훈이의 시작점을 각각 큐에 추가.
불의 확산을 먼저 계산 후, 지훈이의 이동을 처리.
시간 복잡도
불의 BFS: 각 칸을 최대 한 번 방문 → O(R * C).
지훈이의 BFS: 각 칸을 최대 한 번 방문 → O(R * C).
총 시간 복잡도: O(R * C) ≈ 최대 O(10^6) (1초 내 처리 가능).
공간 복잡도
grid, fire_time, jihoon_time: O(R * C).
큐: 최대 O(R * C).
총 공간 복잡도: O(R * C).

"""