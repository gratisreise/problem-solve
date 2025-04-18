from collections import deque

# 입력 처리
m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 초기 익은 토마토 위치 큐에 추가
queue = deque()
for i in range(n):
    for j in range(m):
        if grid[i][j] == 1:
            queue.append((i, j))

# BFS로 토마토 익히기
def bfs():
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == 0:
                grid[nx][ny] = grid[x][y] + 1
                queue.append((nx, ny))

# 토마토 익히기 실행
bfs()

# 결과 계산
max_day = 0
for row in grid:
    for tomato in row:
        if tomato == 0:
            print(-1)
            exit()
    max_day = max(max_day, max(row))

# 결과 출력 (익는데 걸린 날짜는 grid 값에서 1을 빼야 함)
print(max_day - 1)

"""
코드 설명
1. 입력 처리
* 입력:
    * m, n: 격자 크기 (열 M, 행 N).
        * 2 ≤ M, N ≤ 1,000.
    * grid: N×M 격자.
        * 1: 익은 토마토.
        * 0: 익지 않은 토마토.
        * -1: 토마토 없음 (빈 칸).
* 방향 벡터:
    * dx, dy: 상, 하, 좌, 우 이동 ([-1, 1, 0, 0], [0, 0, -1, 1]).
2. 초기 익은 토마토 위치 설정
* 역할: 익은 토마토(1)의 위치를 큐에 추가.
* 흐름:
    * queue: BFS용 deque.
    * 격자 순회하며 grid[i][j] == 1인 위치 (i, j)를 queue에 추가.
    * 모든 익은 토마토가 동시에 확산 시작점 역할을 함.
3. BFS로 토마토 익히기 (bfs 함수)
* 역할: 익은 토마토에서 시작해 인접한 익지 않은 토마토를 익힘.
* 흐름:
    * while queue: 큐가 빌 때까지.
        * x, y: 현재 위치.
        * 4방향 탐색:
            * nx, ny: 새 위치.
            * 조건: 격자 내이고, 익지 않은 토마토(grid[nx][ny] == 0)일 때.
            * grid[nx][ny] = grid[x][y] + 1: 익는 날짜 기록 (이전 값 + 1).
            * queue.append((nx, ny)): 새 위치 추가.
4. 결과 계산
* 변수:
    * max_day: 최대 날짜 (모든 토마토가 익는 데 걸린 시간).
* 흐름:
    * 격자 순회:
        * if tomato == 0: 익지 않은 토마토가 남아있으면:
            * -1 출력 후 종료 (exit()).
        * max_day = max(max_day, max(row)): 각 행의 최대값으로 갱신.
    * 모든 토마토가 익었으면 최대 날짜 계산.
5. 결과 출력
* 출력: max_day - 1.
    * grid 값은 1부터 시작하므로 실제 날짜는 -1 조정.

문제 분석
* 문제: 백준 7576 "토마토".
* 입력:
    * M, N: 격자 크기 (열, 행).
    * N×M 격자.
* 조건:
    * 익은 토마토(1)가 상하좌우로 하루에 하나씩 익힘.
    * 모든 토마토가 익는 최소 날짜 구하기.
    * 익지 않은 토마토가 남으면 -1.
* 출력: 최소 날짜 또는 -1.

시간 복잡도
* 입력: O(N * M) (≈ 10^6).
* BFS:
    * 각 칸은 최대 한 번 방문.
    * O(N * M) (≈ 10^6).
* 결과 계산: O(N * M) (≈ 10^6).
* 총합: O(N * M) (10^8 대비 여유).
* 결과: 1초 내 충분.

공간 복잡도
* grid: O(N * M) ≈ 4MB.
* queue: O(N * M) 최악 경우 (≈ 4MB).
* 총합: 약 8MB (128MB 내 여유).

결론
* 정확성: 조건 충족, 샘플 통과.
* 효율성: 시간 O(N * M), 공간 O(N * M)으로 최적.
* 특징:
    * BFS로 모든 토마토 동시 확산 처리.
    * 날짜를 격자 값으로 직접 기록.
    * 익지 않은 토마토 확인 간단히 구현.
* 검증: N, M 범위 내 효율적 동작.
"""