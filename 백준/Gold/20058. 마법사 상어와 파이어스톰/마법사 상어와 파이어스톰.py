from collections import deque

# 입력 처리
n, q = map(int, input().split())
size = 2 ** n
grid = [list(map(int, input().split())) for _ in range(size)]
levels = list(map(int, input().split()))

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 격자 회전 함수
def rotate(l):
    global grid
    step = 2 ** l  # 부분 격자의 크기
    new_grid = [[0] * size for _ in range(size)]
    for i in range(0, size, step):
        for j in range(0, size, step):
            for x in range(step):
                for y in range(step):
                    new_grid[i + y][j + step - 1 - x] = grid[i + x][j + y]
    grid = new_grid

# 얼음 녹이기 함수
def melt():
    global grid
    new_grid = [row[:] for row in grid]
    for x in range(size):
        for y in range(size):
            if grid[x][y] == 0:
                continue
            cnt = 0
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]
                if 0 <= nx < size and 0 <= ny < size and grid[nx][ny] > 0:
                    cnt += 1
            if cnt < 3:
                new_grid[x][y] -= 1
    grid = new_grid

# BFS로 가장 큰 얼음 덩어리 찾기
def find_largest():
    visited = [[False] * size for _ in range(size)]
    max_size = 0
    for i in range(size):
        for j in range(size):
            if grid[i][j] > 0 and not visited[i][j]:
                q = deque()
                q.append((i, j))
                visited[i][j] = True
                current_size = 1
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx = x + dx[d]
                        ny = y + dy[d]
                        if 0 <= nx < size and 0 <= ny < size and grid[nx][ny] > 0 and not visited[nx][ny]:
                            visited[nx][ny] = True
                            q.append((nx, ny))
                            current_size += 1
                max_size = max(max_size, current_size)
    return max_size

# 파이어스톰 시뮬레이션
for level in levels:
    if level > 0:
        rotate(level)
    melt()

# 결과 계산
total_ice = sum(sum(row) for row in grid)
largest_ice = find_largest()

# 결과 출력
print(total_ice)
print(largest_ice)