import sys
from collections import deque
ip, op = sys.stdin, sys.stdout  # 입출력 설정
dy, dx, dz = [-1, 0, 1, 0, 0, 0], [0, 1, 0, -1, 0, 0], [0, 0, 0, 0, -1, 1]  # 상, 우, 하, 좌, 아래층, 위층

while True:
    s = ip.readline().rstrip()  # 입력 줄
    if s == '': continue  # 빈 줄 무시
    l, r, c = map(int, s.split())  # 층, 행, 열
    if l == r == c == 0: break  # 종료 조건
    a, vis = [], [[[0]*c for _ in range(r)] for _ in range(l)]  # 격자, 방문 배열
    idx = 0
    arr = []
    while idx < l:  # 층별 입력
        temp = ip.readline().rstrip()
        if temp == '':  # 빈 줄: 층 완료
            a.append(arr)
            idx += 1
            arr = []
            continue
        arr.append(list(temp))  # 행 입력
    for i in range(l):
        for j in range(r):
            for k in range(c):
                if a[i][j][k] == 'S':
                    start = (i, j, k)  # 시작점
                elif a[i][j][k] == 'E':
                    end = (i, j, k)  # 출구
    vis[start[0]][start[1]][start[2]] = 1  # 시작점 방문
    q = deque()
    q.append(start)  # 시작점 큐 추가
    while q:
        if vis[end[0]][end[1]][end[2]]: break  # 출구 도달
        z, y, x = q.popleft()  # 현재 위치
        for d in range(6):  # 6방향 탐색
            nz, ny, nx = z + dz[d], y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or nz < 0: continue  # 범위 체크
            if ny >= r or nx >= c or nz >= l: continue
            if a[nz][ny][nx] == '#' or vis[nz][ny][nx]: continue  # 벽이거나 방문済
            vis[nz][ny][nx] = vis[z][y][x] + 1  # 이동 시간 기록
            q.append((nz, ny, nx))  # 다음 위치 추가
    print(f"Escaped in {vis[end[0]][end[1]][end[2]]-1} minute(s)." if vis[end[0]][end[1]][end[2]] else "Trapped!")
    """
    문제 접근 방법과 아이디어
문제 이해
* 목표: 3차원 빌딩에서 시작점(S)에서 출구(E)까지의 최소 이동 시간(분)을 구하기.
* 조건:
    * 빌딩: L×R×C (1 ≤ L, R, C ≤ 30).
    * 격자 값: '.'(빈 칸), '#'(벽), 'S'(시작), 'E'(출구).
    * 이동: 상하좌우(2D) + 층간 이동(상하, 3D), 6방향.
    * 이동 시간: 1분/칸.
    * 입력 종료: L = R = C = 0.
* 출력:
    * 도달 가능: "Escaped in X minute(s)."
    * 불가능: "Trapped!"
접근 아이디어
* BFS:
    * 3차원 격자에서 최단 경로 → BFS 적합.
    * 시작점(S)에서 6방향으로 이동하며 출구(E)까지의 거리 계산.
* 상태 관리:
    * a: 3차원 격자.
    * vis: 방문 배열, 이동 시간 저장.
    * q: BFS 큐, 탐색 위치 저장.
* 구현 전략:
    * 3차원 입력 처리 (층별 입력, 빈 줄 포함).
    * BFS로 최단 경로 탐색.
    * 출구 도달 여부와 시간 확인.
1. 입력 처리
* ip, op = sys.stdin, sys.stdout: 빠른 입출력.
* dy, dx, dz: 6방향 이동 벡터 (상, 우, 하, 좌, 아래층, 위층).
* while True:
    * s: 입력 줄 (L R C).
    * if s == '': 빈 줄 무시.
    * l, r, c: 층, 행, 열.
    * if l == r == c == 0: 종료.
* 3차원 격자 입력:
    * a: L×R×C 격자.
    * idx, arr: 층 인덱스, 현재 층 데이터.
    * while idx < l:
        * temp: 입력 줄.
        * temp == '': 층 완료 → a.append(arr), idx += 1, arr = [].
        * 그 외: arr.append(list(temp))로 행 추가.
* 시작점(S)과 출구(E) 좌표 찾기:
    * for i, j, k: a[i][j][k] == 'S' → start = (i, j, k).
    * a[i][j][k] == 'E' → end = (i, j, k).
2. BFS
* vis = [[[0]*c for _ in range(r)] for _ in range(l)]: 방문 배열.
* vis[start[0]][start[1]][start[2]] = 1: 시작점 방문 (1부터 시작).
* q = deque(): BFS 큐.
* q.append(start): 시작점 추가.
* while q:
    * if vis[end[0]][end[1]][end[2]]: 출구 도달 시 종료.
    * z, y, x = q.popleft(): 현재 위치.
    * 6방향 탐색:
        * nz, ny, nx: 다음 위치.
        * 범위 벗어남: 스킵.
        * 벽(a[nz][ny][nx] == '#') 또는 방문済: 스킵.
        * vis[nz][ny][nx] = vis[z][y][x] + 1: 이동 시간 기록.
        * q.append((nz, ny, nx)): 다음 위치 추가.
3. 출력
* vis[end[0]][end[1]][end[2]]:
    * 0이 아니면: Escaped in {vis[end[0]][end[1]][end[2]]-1} minute(s)..
    * 0이면: Trapped!.

문제 분석
* 문제: 백준 6593 "상범 빌딩".
* 입력: 여러 L, R, C, L×R×C 격자, 종료 (0 0 0).
* 출력: 최소 이동 시간 또는 "Trapped!".
* 조건: 3D 격자, 6방향 이동, 벽 통과 불가.

시간 복잡도
* BFS: O(L * R * C) (최악 모든 칸 방문).
* 입력 처리: O(L * R * C).
* 총합: O(L * R * C) (L, R, C ≤ 30, ≈ 27,000), 1초 내 충분.

    """