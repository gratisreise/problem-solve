def check(i, j, board, mat):
    for y in range(i, i + mat):
        for x in range(j, j + mat):
            if board[y][x] != "-1":
                return False
    return True

def solution(mats, park):
    n, m = len(park), len(park[0])
    ret = -1 
    for i in range(n):
        for j in range(m):
            if park[i][j] != "-1":
                continue
            for mat in mats:
                if mat <= ret or mat > min(n, m): continue
                if i + mat > n or j + mat > m:
                    continue
                if check(i,j, park, mat):
                    ret = mat
    return ret
"""
가지고 있는거 정해져있음
순회하면서 

"""