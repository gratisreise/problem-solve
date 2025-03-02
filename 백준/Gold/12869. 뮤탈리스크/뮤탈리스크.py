from itertools import permutations
from collections import deque
#전처리
atk = [9, 3, 1]
atks = list(permutations(atk, 3))
vis, q = [[[0]*61 for _ in range(61)]for _ in range(61)],deque() 
n = int(input())
a = [0]*3
for i, num in enumerate(map(int, input().split())):
    a[i] = num

vis[a[0]][a[1]][a[2]] = 1
q.append(tuple(a))
#탐색
while q:
    y, x, z = q.popleft()
    if vis[0][0][0]:
        print(vis[0][0][0]-1)
        exit()
    for atk in atks:
        ny = max(0, y - atk[0])
        nx = max(0, x - atk[1])
        nz = max(0, z - atk[2])
        if vis[ny][nx][nz]: continue
        vis[ny][nx][nz] = vis[y][x][z] + 1
        q.append((ny, nx, nz))