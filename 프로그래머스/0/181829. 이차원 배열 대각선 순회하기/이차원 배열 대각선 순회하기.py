def solution(board, k):
    ret, row, col = 0, len(board), len(board[0])
    for i in range(row):
        for j in range(col):
            if i + j <= k:
                ret += board[i][j]
    return ret