def solution(keyinput, board):
    col, row = board
    col //= 2
    row //= 2
    x,y = 0, 0
    for cmd in keyinput:
        nx, ny = x, y
        if cmd == "left":
            nx -= 1
        elif cmd == "right":
            nx += 1
        elif cmd == "up":
            ny += 1
        elif cmd == "down":
            ny -= 1
        if abs(ny) > row or abs(nx) > col:
            continue
        x, y = nx, ny
    return [x, y]
# (0, 0) 시작, (x,y) 리턴 