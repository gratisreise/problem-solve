def solution(board):
    dy = [-1, 0, 1, 0, 1, 1, -1,-1]
    dx = [0, 1, 0, -1, -1,1, 1, -1]
    n, m = len(board), len(board[0])
    temp = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            for d in range(8):
                if board[i][j] == 0: continue
                temp[i][j] = 1
                ny, nx = i + dy[d], j + dx[d]
                if ny < 0 or nx < 0 or ny >= n or nx >= m:
                    continue
                temp[ny][nx] = 1
    ret = 0
    for i in range(n):
        ret += sum(1 for j in range(m) if temp[i][j] == 0)
    return ret