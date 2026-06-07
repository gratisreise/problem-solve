def solution(board, h, w):
    n = len(board)
    count = 0
    dh,dw = [0, 1, -1, 0], [1, 0 ,0, -1]
    for d in range(4):
        h_check = h + dh[d]
        w_check = w + dw[d]
        if (0 <= h_check < n) and (0 <= w_check < n):
            if board[h][w] == board[h_check][w_check]:
                count += 1
    return count
"""
이웃한 놈들중 같은 색으로 칠한칸 갯수
1.
"""