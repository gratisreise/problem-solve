from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write

# 방향 벡터 (상하좌우)
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

# 입력: 행 R, 열 C
R, C = map(int, input().split())

# 호수 맵과 방문 배열 초기화
lake = []
water_visited = [[False] * C for _ in range(R)]
swan_visited = [[False] * C for _ in range(R)]

# 백조 위치와 물 큐 초기화
swan_pos = None
water_q = deque()
swan_q = deque()

# 맵 입력 및 초기 설정
for i in range(R):
    row = input().rstrip()
    lake.append(list(row))
    for j, cell in enumerate(row):
        if cell in ('.', 'L'):  # 물 또는 백조 위치
            water_visited[i][j] = True
            water_q.append((i, j))
        if cell == 'L' and swan_pos is None:  # 첫 번째 백조 위치 저장
            swan_pos = (i, j)

# 백조 탐색 시작점 추가
swan_q.append(swan_pos)
swan_visited[swan_pos[0]][swan_pos[1]] = True

# 물 녹이기 함수
def melt_water():
    next_water_q = deque()
    while water_q:
        y, x = water_q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if not (0 <= ny < R and 0 <= nx < C) or water_visited[ny][nx]:
                continue
            if lake[ny][nx] == 'X':
                water_visited[ny][nx] = True
                next_water_q.append((ny, nx))
                lake[ny][nx] = '.'
    return next_water_q

# 백조 이동 함수
def move_swan():
    next_swan_q = deque()
    while swan_q:
        y, x = swan_q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if not (0 <= ny < R and 0 <= nx < C) or swan_visited[ny][nx]:
                continue
            swan_visited[ny][nx] = True
            if lake[ny][nx] == '.':
                swan_q.append((ny, nx))
            elif lake[ny][nx] == 'X':
                next_swan_q.append((ny, nx))
            elif lake[ny][nx] == 'L':
                return True, next_swan_q
    return False, next_swan_q

# 메인 로직
day = 0
while True:
    found, next_swan_q = move_swan()
    if found:
        break
    water_q = melt_water()
    swan_q = next_swan_q
    day += 1

# 결과 출력
print(f"{day}\n")


"""
1. 초기화
 - 호수 맵과 방문배열을 설정.
 - 물과 백조의 초기 위치를 큐에 추가
 - 백조 탐색의 시작점을 첫 번째 백조 위치로 설정.
2. 물녹이기
 - 현재 물 위치에서 상하좌우로 얼음을 탐색
 - 얼음을 물로 바꾸고, 다음 날 녹일 위치를 큐에 저장
3. 백조이동
 - 현재 백조 위치에서 상하좌우로 이동 가능성 탐색
 - 물은 즉시 이동, 얼음은 다음 날 이동, 다른 백조 만나면 종료
 - 다음 날 탐색할 위치를 별도 큐에 저장
4. 메인 루프:
 - 백조가 만날 때까지 반복:
  - 백조 이동 시도
  - 물 녹이기.
  - 다음 날 준비(큐 업데이트)
  - 날짜 증가
5. 출력:
 - 백조가 만난 날짜 출력
"""