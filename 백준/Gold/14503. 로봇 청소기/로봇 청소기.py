import sys

input = sys.stdin.readline

# 방 크기 입력
n, m = map(int, input().split())

# 로봇 청소기 초기 위치 및 방향 입력
r, c, d = map(int, input().split())

# 방 정보 입력
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

# 방향 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 청소 횟수
count = 0

while True:
    # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if board[r][c] == 0:
        board[r][c] = 2  # 청소된 칸은 2로 표시
        count += 1

    # 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    check = False
    for i in range(4):
        nx, ny = r + dx[i], c + dy[i]
        if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 0:
            check = True
            break

    if not check:
        # 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        nx, ny = r - dx[d], c - dy[d]
        if 0 <= nx < n and 0 <= ny < m and board[nx][ny] != 1:
            r, c = nx, ny
        else:
            # 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            break
    else:
        # 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        # 3-1. 반시계 방향으로 90도 회전한다.
        d = (d + 3) % 4
        # 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        nx, ny = r + dx[d], c + dy[d]
        if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 0:
            r, c = nx, ny

print(count)