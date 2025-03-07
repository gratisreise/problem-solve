from collections import deque
import sys
from itertools import permutations

input = sys.stdin.readline

# 판 입력
boards = []
for _ in range(5):
    board = [list(map(int, input().split())) for _ in range(5)]
    boards.append(board)

# 판 회전
def rotate(board):
    return [list(row) for row in zip(*board[::-1])]

# 3D BFS
def bfs(cube):
    # 입구 (0,0,0), 출구 (4,4,4) 고정
    start, end = (0, 0, 0), (4, 4, 4)
    if cube[start[0]][start[1]][start[2]] == 0 or cube[end[0]][end[1]][end[2]] == 0:
        return -1
    
    visited = [[[False]*5 for _ in range(5)] for _ in range(5)]
    queue = deque([start])
    visited[start[0]][start[1]][start[2]] = True
    dist = [[[0]*5 for _ in range(5)] for _ in range(5)]
    
    dz = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]
    dx = [0, 0, 0, 0, -1, 1]
    
    while queue:
        z, y, x = queue.popleft()
        if (z, y, x) == end:
            return dist[z][y][x]
        
        for i in range(6):
            nz, ny, nx = z + dz[i], y + dy[i], x + dx[i]
            if (0 <= nz < 5 and 0 <= ny < 5 and 0 <= nx < 5 and 
                not visited[nz][ny][nx] and cube[nz][ny][nx] == 1):
                visited[nz][ny][nx] = True
                dist[nz][ny][nx] = dist[z][y][x] + 1
                queue.append((nz, ny, nx))
    return -1

# 모든 경우 탐색
min_moves = float('inf')

# 각 판의 회전 상태 미리 준비
rotated_boards = []
for i in range(5):
    rotated = [boards[i]]
    for _ in range(3):
        rotated.append(rotate(rotated[-1]))
    rotated_boards.append(rotated)

# 순서와 회전 조합
for order in permutations(range(5)):
    for r0 in range(4):
        for r1 in range(4):
            for r2 in range(4):
                for r3 in range(4):
                    for r4 in range(4):
                        cube = [
                            rotated_boards[order[0]][r0],
                            rotated_boards[order[1]][r1],
                            rotated_boards[order[2]][r2],
                            rotated_boards[order[3]][r3],
                            rotated_boards[order[4]][r4]
                        ]
                        
                        # BFS 한 번만 호출
                        moves = bfs(cube)
                        if moves != -1:
                            min_moves = min(min_moves, moves)
                            if min_moves == 12:  # 최단 경로 발견
                                print(12)
                                sys.exit(0)
                        
                        # 입구/출구 모두 막힌 경우 더 탐색 불필요
                        if cube[0][0][0] == 0 and cube[4][4][4] == 0:
                            break

print(-1 if min_moves == float('inf') else min_moves)