def dfs(y, x):
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if ny < 0 or ny >= n or nx < 0 or nx >= m or visited[ny][nx] or a[ny][nx] == 1:
            continue
        visited[ny][nx] = 1
        dfs(ny, nx)

def solve():
    # visited 배열 초기화
    for i in range(n):
        for j in range(m):
            visited[i][j] = 0
    
    # 바이러스 시작점에서 DFS 실행
    for y, x in virus_list:
        visited[y][x] = 1
        dfs(y, x)
    
    # 안전 영역 크기 계산
    cnt = 0
    for i in range(n):
        for j in range(m):
            if a[i][j] == 0 and not visited[i][j]:
                cnt += 1
    return cnt

# 방향 배열 (상, 우, 하, 좌)
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 입력 받기
n, m = map(int, input().split())
a = [[0] * m for _ in range(n)]
visited = [[0] * m for _ in range(n)]
virus_list = []
wall_list = []

# 맵 입력 및 바이러스, 벽 위치 저장
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        a[i][j] = row[j]
        if a[i][j] == 2:
            virus_list.append((i, j))
        if a[i][j] == 0:
            wall_list.append((i, j))

# 최대 안전 영역 크기 계산
ret = 0
for i in range(len(wall_list)):
    for j in range(i):
        for k in range(j):
            # 벽 3개 세우기
            a[wall_list[i][0]][wall_list[i][1]] = 1
            a[wall_list[j][0]][wall_list[j][1]] = 1
            a[wall_list[k][0]][wall_list[k][1]] = 1
            
            # 안전 영역 크기 계산
            ret = max(ret, solve())
            
            # 벽 복원
            a[wall_list[i][0]][wall_list[i][1]] = 0
            a[wall_list[j][0]][wall_list[j][1]] = 0
            a[wall_list[k][0]][wall_list[k][1]] = 0

print(ret)