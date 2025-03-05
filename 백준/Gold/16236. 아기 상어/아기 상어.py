import sys
from collections import deque

input = sys.stdin.readline

# 공간의 크기 입력
n = int(input())

# 공간 정보 입력
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

# 아기 상어 초기 위치 및 크기 설정
shark_x, shark_y = 0, 0
shark_size = 2
shark_eat = 0

# 아기 상어 초기 위치 찾기
for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            shark_x, shark_y = i, j
            board[i][j] = 0  # 아기 상어 위치 빈 칸으로 변경
            break

# 이동 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 시간 계산
time = 0

while True:
    # 먹을 수 있는 물고기 찾기
    fishes = []
    visited = [[False] * n for _ in range(n)]
    queue = deque([(shark_x, shark_y, 0)])
    visited[shark_x][shark_y] = True

    while queue:
        x, y, dist = queue.popleft()

        # 물고기 발견 시
        if board[x][y] != 0 and board[x][y] < shark_size:
            fishes.append((dist, x, y))

        # 4방향 탐색
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and board[nx][ny] <= shark_size:
                queue.append((nx, ny, dist + 1))
                visited[nx][ny] = True

    # 먹을 수 있는 물고기가 없는 경우
    if not fishes:
        break

    # 가장 가까운 물고기 선택 (거리, 상, 좌 우선순위)
    fishes.sort()
    dist, fish_x, fish_y = fishes[0]

    # 물고기 먹기
    time += dist
    shark_x, shark_y = fish_x, fish_y
    board[fish_x][fish_y] = 0
    shark_eat += 1

    # 아기 상어 크기 증가
    if shark_eat == shark_size:
        shark_size += 1
        shark_eat = 0

print(time)
"""
코드 설명:

입력:

공간의 크기 n을 입력받습니다.
공간 정보를 board 리스트에 입력받습니다.
초기 설정:

아기 상어의 초기 위치 shark_x, shark_y와 크기 shark_size, 먹은 물고기 수 shark_eat을 설정합니다.
이동 방향을 나타내는 dx, dy 리스트를 정의합니다.
시간을 저장하는 time 변수를 0으로 초기화합니다.
아기 상어 이동:

while 루프를 사용하여 아기 상어를 이동시킵니다.
먹을 수 있는 물고기 찾기: BFS를 사용하여 아기 상어로부터 가장 가까운 물고기를 찾습니다.
물고기 선택: 찾은 물고기 중 가장 가까운 물고기를 선택합니다.
물고기 먹기: 선택한 물고기를 먹고, 아기 상어의 위치를 변경합니다.
아기 상어 크기 증가: 먹은 물고기 수가 아기 상어의 크기와 같아지면 아기 상어의 크기를 증가시킵니다.
먹을 수 있는 물고기가 없는 경우: 루프를 종료합니다.
결과 출력:

시간을 출력합니다.
핵심 로직:

BFS: 아기 상어로부터 가장 가까운 물고기를 찾습니다.
우선순위 큐: 물고기를 찾을 때 거리, 상, 좌 우선순위를 고려합니다.
아기 상어 크기 증가: 먹은 물고기 수에 따라 아기 상어의 크기를 증가시킵니다.
코드 최적화:

BFS 최적화: 방문 여부를 확인하여 중복 탐색을 방지합니다.
우선순위 큐 최적화: 물고기를 찾을 때 우선순위를 고려하여 불필요한 탐색을 줄입니다.
"""