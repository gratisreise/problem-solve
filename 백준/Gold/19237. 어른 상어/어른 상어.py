import sys

# 상어 이동 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def move_sharks():
    global sharks, smell, grid
    new_grid = [[0] * n for _ in range(n)]
    for num in range(1, m + 1):
        if sharks[num] == None:
            continue
        x, y, dir = sharks[num]
        # 빈 칸 찾기
        found = False
        for i in range(4):
            ndir = priority[num][dir][i]
            nx = x + dx[ndir]
            ny = y + dy[ndir]
            if 0 <= nx < n and 0 <= ny < n and (isinstance(smell[nx][ny], int) or smell[nx][ny][1] == 0):
                found = True
                break
        # 빈 칸 못 찾으면 자신의 냄새가 있는 칸으로 이동
        if not found:
            for i in range(4):
                ndir = priority[num][dir][i]
                nx = x + dx[ndir]
                ny = y + dy[ndir]
                if 0 <= nx < n and 0 <= ny < n and isinstance(smell[nx][ny], list) and smell[nx][ny][0] == num:
                    break
        # 이동
        if new_grid[nx][ny] != 0:
            if new_grid[nx][ny] < num:
                sharks[num] = None
            else:
                sharks[new_grid[nx][ny]] = None
                new_grid[nx][ny] = num
                sharks[num] = (nx, ny, ndir)
        else:
            new_grid[nx][ny] = num
            sharks[num] = (nx, ny, ndir)
    grid = new_grid

def update_smell():
    global smell
    for i in range(n):
        for j in range(n):
            if isinstance(smell[i][j], list):
                smell[i][j][1] -= 1
                if smell[i][j][1] == 0:
                    smell[i][j] = 0
    for num in range(1, m + 1):
        if sharks[num] != None:
            x, y, _ = sharks[num]
            smell[x][y] = [num, k]

def check():
    for num in range(2, m + 1):
        if sharks[num] != None:
            return False
    return True

# 입력 처리
n, m, k = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
sharks = [None] * (m + 1)
for i in range(n):
    for j in range(n):
        if grid[i][j] != 0:
            sharks[grid[i][j]] = (i, j, 0)
initial_dir = list(map(int, sys.stdin.readline().split()))
for num in range(1, m + 1):
    x, y, _ = sharks[num]
    sharks[num] = (x, y, initial_dir[num - 1] - 1)
priority = [[[0] * 4 for _ in range(4)] for __ in range(m + 1)]
for num in range(1, m + 1):
    for dir in range(4):
        priority[num][dir] = list(map(lambda x: int(x) - 1, sys.stdin.readline().split()))
smell = [[0] * n for _ in range(n)]
for num in range(1, m + 1):
    if sharks[num] != None:
        x, y, _ = sharks[num]
        smell[x][y] = [num, k]

# 시뮬레이션 실행
time = 0
while time <= 1000:
    if check():
        break
    move_sharks()
    update_smell()
    time += 1

# 결과 출력
print(time if time <= 1000 else -1)