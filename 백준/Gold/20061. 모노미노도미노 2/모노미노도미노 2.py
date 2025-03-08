def put_block(t, x, y, board):
    if t == 1:
        board[x][y] = 1
    elif t == 2:
        board[x][y] = 1
        board[x][y+1] = 1
    elif t == 3:
        board[x][y] = 1
        board[x+1][y] = 1

def drop_block(t, x, y, board):
    if t == 1:
        while x < 9 and board[x+1][y] == 0:
            x += 1
        board[x][y] = 1
    elif t == 2:
        while x < 9 and board[x+1][y] == 0 and board[x+1][y+1] == 0:
            x += 1
        board[x][y] = 1
        board[x][y+1] = 1
    elif t == 3:
        while x < 8 and board[x+2][y] == 0:
            x += 1
        board[x][y] = 1
        board[x+1][y] = 1

def check_line(board):
    global score
    i = 9
    while i >= 6:
        if all(board[i][j] == 1 for j in range(4)):
            score += 1
            board.pop(i)
            board.insert(0, [0]*4)
        else:
            i -= 1

def check_special(board):
    cnt = 0
    for i in range(4, 6):
        if any(board[i][j] == 1 for j in range(4)):
            cnt += 1
    for _ in range(cnt):
        board.pop()
        board.insert(0, [0]*4)

# 초기화
green = [[0]*4 for _ in range(10)]
blue = [[0]*4 for _ in range(10)]
score = 0

# 입력 처리
n = int(input())
for _ in range(n):
    t, x, y = map(int, input().split())
    drop_block(t, 0, y, green)
    if t == 1:
        drop_block(t, 0, x, blue)
    elif t == 2:
        drop_block(3, 0, x, blue)
    elif t == 3:
        drop_block(2, 0, x, blue)
    check_line(green)
    check_line(blue)
    check_special(green)
    check_special(blue)

# 결과 출력
print(score)
print(sum(sum(row) for row in green) + sum(sum(row) for row in blue))