from collections import deque

# 이동 방향 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def find_p(tx, ty):
    if (tx, ty) in ps:
        return (tx, ty, 0)
    q = deque()
    q.append((tx, ty, 0))
    v = [[-1] * n for _ in range(n)]
    v[tx][ty] = 0
    cand = []
    min_d = float('inf')
    while q:
        x, y, d = q.popleft()
        if d > min_d:
            break
        if (x, y) in ps:
            cand.append((x, y))
            min_d = d
            continue
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and g[nx][ny] == 0 and v[nx][ny] == -1:
                v[nx][ny] = d + 1
                q.append((nx, ny, d + 1))
    if not cand:
        return None
    cand.sort()
    return (cand[0][0], cand[0][1], min_d)

def move_to_d(sx, sy, ex, ey):
    q = deque()
    q.append((sx, sy, 0))
    v = [[-1] * n for _ in range(n)]
    v[sx][sy] = 0
    while q:
        x, y, d = q.popleft()
        if x == ex and y == ey:
            return d
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and g[nx][ny] == 0 and v[nx][ny] == -1:
                v[nx][ny] = d + 1
                q.append((nx, ny, d + 1))
    return -1

def start_taxi(tx, ty, f):
    global ps
    while ps:
        # 가장 가까운 승객 찾기
        p = find_p(tx, ty)
        if p == None:
            return -1
        px, py, d = p
        # 승객까지 이동
        if f < d:
            return -1
        f -= d
        # 승객 정보에서 제거
        ex, ey = ps[(px, py)]
        del ps[(px, py)]
        # 목적지까지 이동
        d_to_dest = move_to_d(px, py, ex, ey)
        if d_to_dest == -1 or f < d_to_dest:
            return -1
        f -= d_to_dest
        # 목적지 도착 후 연료 충전
        f += d_to_dest * 2
        # 택시 위치 업데이트
        tx, ty = ex, ey
    return f

# 입력 처리
n, m, f = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(n)]
tx, ty = map(int, input().split())
tx -= 1
ty -= 1
ps = {}
for _ in range(m):
    px, py, ex, ey = map(int, input().split())
    ps[(px - 1, py - 1)] = (ex - 1, ey - 1)

# 시뮬레이션 실행
res = start_taxi(tx, ty, f)

# 결과 출력
print(res)
