def rotate(pos, maps):
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
    sx, sy, ex, ey = pos
    x, y, d = sx, sy, 0
    next = maps[sx][sy]
    ans = maps[sx][sy]
    
    while True:
        nx, ny = x + dx[d], y + dy[d]
        if sx <= nx <= ex and sy <= ny <= ey:
            ans = min(ans ,maps[nx][ny])
            maps[nx][ny], next = next, maps[nx][ny]
        else:
            d += 1
            nx, ny = x + dx[d], y + dy[d]
            ans = min(ans ,maps[nx][ny])
            maps[nx][ny], next = next, maps[nx][ny]
        if nx == sx and ny == sy: break
        x, y = nx, ny   

    return ans
def solution(rows, columns, queries):
    maps = [[(i*columns + (j+1)) for j in range(columns)] for i in range(rows)]
    return [rotate([x-1 for x in arr], maps) for arr in queries]
"""
테두리 부분 시계방향으로 한칸씩 회전
100 * 100 크기 맵
회전 10000개
x행 y열
1. 모든 회전에 대해 다음을 반복
    1-1. 경계에 도착하면 방향전환
    1-2. 최소숫자찾기
    1-3. 회전 완료되면 숫자 저장
2. 저장된 숫자 반환
"""