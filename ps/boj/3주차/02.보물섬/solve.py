from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌

def bfs(i, j, vis):
    vis[i][j] = 1  # 시작점 방문
    q = deque()
    q.append((i, j))
    while q:
        y, x = q.popleft()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if a[ny][nx] == 'W' or vis[ny][nx]:  # 바다이거나 방문済
                continue
            vis[ny][nx] = vis[y][x] + 1  # 거리 기록
            q.append((ny, nx))
            global ret
            ret = max(ret, vis[ny][nx])  # 최대 거리 갱신

ret = -int(1e9)  # 최대 최단 거리
a, land = [], []  # 격자, 육지 좌표

n, m = map(int, input().split())  # 격자 크기
for i in range(n):
    a.append(list(input()))  # 격자 입력
    for j in range(m):
        if a[i][j] == 'L':
            land.append((i, j))  # 육지 좌표 저장

for pos in land:
    vis = [[0]*m for _ in range(n)]  # 방문 배열 초기화
    bfs(*pos, vis)  # 각 육지에서 BFS

print(ret-1 if len(land) else 0)  # 결과 출력

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 육지(L)에서 다른 육지(L)까지의 최단 거리 중 최대값 구하기.
* 조건:
    * 격자: N×M (1 ≤ N, M ≤ 50).
    * 격자 값: L(육지), W(바다).
    * 이동: 상하좌우, 육지로만 가능.
    * 거리: 한 칸 이동 시 1.
* 출력: 최대 최단 거리 (육지 없으면 0).
접근 아이디어
* BFS:
    * 각 육지(L)에서 시작하여 모든 육지까지의 최단 거리 계산.
    * BFS로 각 시작점에서 최대 거리 구함.
* 브루트 포스:
    * 모든 육지에서 BFS 수행, 최대 거리 갱신.
* 상태 관리:
    * a: 격자 상태.
    * land: 육지 좌표 리스트.
    * vis: 방문 배열, 거리 저장.
    * ret: 최대 최단 거리.
* 구현 전략:
    * 육지 좌표 수집.
    * 각 육지에서 BFS로 최대 거리 계산.
    * 최종 최대값 출력.
1. 입력 처리
* n, m: 격자 세로(N), 가로(M).
* dy, dx: 4방향 이동 벡터.
* ret = -int(1e9): 최대 최단 거리 초기값.
* a: N×M 격자 입력 (문자열 리스트, 'L' 또는 'W').
* land: 육지('L') 좌표 리스트.
* 격자 순회:
    * a[i][j] == 'L': land.append((i, j)).
2. BFS 함수
* bfs(i, j, vis):
    * vis[i][j] = 1: 시작점 방문 (거리 1부터).
    * q = deque(): BFS 큐.
    * q.append((i, j)): 시작점 추가.
    * while q:
        * y, x = q.popleft(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 바다(a[ny][nx] == 'W') 또는 방문済: 스킵.
            * vis[ny][nx] = vis[y][x] + 1: 거리 기록.
            * q.append((ny, nx)): 다음 위치 추가.
            * ret = max(ret, vis[ny][nx]): 최대 거리 갱신.
3. 최대 거리 계산
* for pos in land: 각 육지에서:
    * vis = [[0]*m for _ in range(n)]: 방문 배열 초기화.
    * bfs(*pos, vis): BFS 호출.
4. 출력
* ret-1 if len(land) else 0:
    * len(land) > 0: BFS 거리 1부터 시작 → ret-1.
    * len(land) == 0: 육지 없음 → 0.
* print(...): 결과 출력.

문제 분석
* 문제: 백준 2589 "보물섬".
* 입력: N, M, N×M 격자.
* 출력: 최대 최단 거리.
* 조건: 육지 간 상하좌우 이동, 최단 거리 중 최대값.

시간 복잡도
* BFS: O(N * M) (각 칸 최대 1번 방문).
* 육지 수: O(N * M) (최악 모든 칸).
* 총합: O(N * M * N * M) (N, M ≤ 50, ≈ 50^4 ≈ 6.25×10^6), 1초 내 충분.

"""