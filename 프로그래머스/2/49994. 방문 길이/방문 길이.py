def solution(dirs):
    dir = {x:i for i, x in enumerate("UDRL")}
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    y, x = 0, 0
    ret = set()
    for c in dirs:
        ny, nx = y + dy[dir[c]], x + dx[dir[c]]
        if ny < -5 or nx < -5 or ny > 5 or nx > 5: continue
        ret.add((y, x, ny, nx))
        ret.add((ny, nx, y, x))
        y, x = ny, nx
    return len(ret)/2

# 캐릭터가 처음 걸어본 길의 길이
# 그냥 2차원 배열의 1의 갯수가 
# ret 한다음 1이면 ++ 아니면 안더하기