pattern1,pattern2 = "WBWBWBWB", "BWBWBWBW"
board1 = [[*pattern1] if i % 2 == 0 else [*pattern2] for i in range(8)]
board2 = [[*pattern2] if i % 2 == 0 else [*pattern1] for i in range(8)]
n,m = map(int, input().split())
board = [[0]*m for _ in range(n)]
def count(y,x):
    cnt1, cnt2 = 0, 0
    temp = [[board[i][j] for j in range(x, x+8)] for i in range(y, y+8)]
    for i in range(8):
        for j in range(8):
            if temp[i][j] != board1[i][j]:
                cnt1 += 1
            elif temp[i][j] != board2[i][j]:
                cnt2 += 1
    return min(cnt1, cnt2)

for i in range(n):
    board[i] = [*input()]
ret = 65
for i in range(n-7):
    for j in range(m-7):
        # print(i,j)
        ret = min(count(i,j), ret)
print(ret)