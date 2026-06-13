def solution(n):
    ret = [[0]*n for _ in range(n)]
    y,x = 0, 0
    num, d = 1, 0
    dy,dx = [0, 1,0,-1], [1,0,-1,0]
    while True:
        ret[y][x] = num
        ny, nx = y + dy[d], x + dx[d]
        if ny < 0 or ny >= n or nx < 0 or nx >= n or (ret[ny][nx] != 0):
            d = (d + 1) % 4
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or ny >= n or nx < 0 or nx >= n or (ret[ny][nx] != 0):
                break
        y, x = ny, nx
        num += 1
    return ret
        
"""
[조건]
30보다 작거나 같다

[아이디어]
점하나를 나선으로 이동시키면서 값을 채운다
0이 아닌 경우가 있을 때 회전 또는 멈춘다(2번 만날 경우 멈춘다)
경계밖을 만나면 회전한다(시계방향)
[로직]
1. y,x를 이용해 좌표점을 움직인다
2. 한번의 변경이후 숫자를 만나면 그때는 종료
3. 회전하면서 이동점을 이동하면서 값을 채운다
"""