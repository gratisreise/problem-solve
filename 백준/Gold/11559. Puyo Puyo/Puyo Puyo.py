from collections import deque
dy, dx = [-1, 0, 1, 0],[0, 1, 0, -1]
a = []
for i in range(12):
    a.append(list(input()))
ret = 0
while True:   
    boom = False
    vis = [[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if a[i][j] == '.' or vis[i][j]: 
                continue
            stk, temp, vis[i][j] = deque(), [(i,j)], 1
            stk.append((i,j))
            while stk:
                y, x = stk.pop()
                for d in range(4):
                    ny, nx = y + dy[d], x + dx[d]
                    if not(0 <= ny < 12 and 0 <= nx < 6):
                        continue
                    if a[ny][nx] == '.' or a[ny][nx] != a[y][x] or vis[ny][nx]:
                        continue
                    vis[ny][nx] = 1
                    stk.append((ny, nx))
                    temp.append((ny, nx))
            if len(temp) < 4: 
                for i, j in temp:
                    vis[i][j] = 0
                continue
            for i, j in temp:
                a[i][j] = '.'
            boom = True
    if not boom: break
    ret += 1
    for j in range(6):
        for i in range(11, -1, -1):
            if a[i][j] == '.':
                temp = i
                while temp > 0 and a[temp][j] == '.':
                    temp -= 1
                if a[temp][j] != '.':
                    a[i][j], a[temp][j] = a[temp][j], a[i][j]
print(ret)