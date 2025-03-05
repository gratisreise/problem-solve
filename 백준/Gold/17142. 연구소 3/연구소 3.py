import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
lab = []
viruses = []
empty_cnt = 0

for i in range(n):
    row = list(map(int, input().split()))
    lab.append(row)
    for j in range(n):
        if row[j] == 2:
            viruses.append((i, j))
        elif row[j] == 0:
            empty_cnt += 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(active_viruses):
    q = deque(active_viruses)
    visited = [[-1] * n for _ in range(n)]
    for x, y in active_viruses:
        visited[x][y] = 0
    cnt = 0
    time = 0
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1 and lab[nx][ny] != 1:
                visited[nx][ny] = visited[x][y] + 1
                if lab[nx][ny] == 0:
                    cnt += 1
                    time = visited[nx][ny]
                q.append((nx, ny))
    
    if cnt == empty_cnt:
        return time
    else:
        return float('inf')

if empty_cnt == 0:
    print(0)
else:
    min_time = float('inf')
    for active_viruses in combinations(viruses, m):
        min_time = min(min_time, bfs(active_viruses))
    
    if min_time == float('inf'):
        print(-1)
    else:
        print(min_time)