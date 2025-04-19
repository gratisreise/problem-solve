from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌

def dfs(i, j, vis):
    vis[i][j] = 1  # 시작점 방문
    stk = deque()
    stk.append((i, j))
    while stk:
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if a[ny][nx] == 0 or vis[ny][nx] != 0:  # 바다이거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가

def melt(i, j):
    cnt = 0  # 주변 바다 수
    for d in range(4):
        ny, nx = i + dy[d], j + dx[d]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if a[ny][nx] == 0:
            cnt += 1  # 바다면 카운트
    return cnt

n, m = map(int, input().split())  # 격자 크기
time, a, ice = 0, [], []  # 시간, 격자, 빙산 좌표
for i in range(n):
    a.append(list(map(int, input().split())))
    for j in range(m):
        if a[i][j] != 0:
            ice.append((i, j))  # 빙산 좌표 저장

INF = int(1e9)
ret = INF  # 분리 시간

while ice:
    vis = [[0]*m for _ in range(n)]  # 방문 배열 초기화
    cnt = 0  # 덩어리 수
    for i, j in ice:  # 연결 확인
        if vis[i][j] == 0:
            dfs(i, j, vis)
            cnt += 1
    if cnt > 1:  # 덩어리 2개 이상
        ret = min(ret, time)
        break
    ice_melt = []
    for i, j in ice:
        ice_melt.append(melt(i, j))  # 각 빙산의 녹는 양
    for idx, (i, j) in enumerate(ice):
        a[i][j] = max(0, a[i][j] - ice_melt[idx])  # 높이 갱신
    ice = [x for x in ice if a[x[0]][x[1]] != 0]  # 녹지 않은 빙산
    time += 1

print(ret if ret != INF else 0)  # 결과 출력
"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 빙산이 녹다가 두 덩이 이상으로 분리되는 시간 구하기.
* 조건:
    * 격자: N×M (3 ≤ N, M ≤ 300).
    * 격자 값: 0(바다), 양수(빙산 높이).
    * 빙산 녹음: 상하좌우 바다(0)와 접촉한 수만큼 높이 감소.
    * 분리: 연결된 빙산 덩어리가 2개 이상.
    * 빙산이 모두 녹으면 분리 없음.
* 출력: 분리 시간 (분리 없으면 0).
접근 아이디어
* 시뮬레이션:
    * 매 시간:
        * 빙산 높이 감소 (주변 바다 수만큼).
        * 빙산 연결성 확인 (DFS로 덩어리 수 계산).
    * 덩어리 ≥ 2: 분리 시간 기록.
    * 빙산 모두 녹음: 0 출력.
* DFS:
    * 빙산(높이 > 0)에서 연결된 덩어리 탐색.
    * 방문 배열로 중복 방지.
* 상태 관리:
    * a: 격자 상태.
    * ice: 빙산 좌표 리스트.
    * vis: 방문 배열.
    * ret: 분리 시간.
* 구현 전략:
    * 빙산 녹음 → DFS로 덩어리 수 확인 → 반복.
    * 최적화: 빙산 좌표 저장으로 효율적 처리.
1. 입력 처리
* n, m: 격자 세로(N), 가로(M).
* dy, dx: 4방향 이동 벡터.
* time: 경과 시간.
* a: N×M 격자 입력.
* ice: 빙산 좌표 리스트, a[i][j] != 0인 (i,j) 저장.
* INF, ret: 분리 시간 초기값 (INF).
2. DFS 함수
* dfs(i, j, vis):
    * vis[i][j] = 1: 시작점 방문.
    * stk = deque(): 스택으로 DFS.
    * stk.append((i, j)): 시작점 추가.
    * while stk:
        * y, x = stk.pop(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 바다(a[ny][nx] == 0) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
3. 녹는 양 계산 함수
* melt(i, j):
    * cnt: 주변 바다 수.
    * 4방향 탐색:
        * ny, nx: 인접 위치.
        * 범위 벗어남: 스킵.
        * a[ny][nx] == 0: 바다 → cnt += 1.
    * return cnt: 녹는 양 반환.
4. 시뮬레이션 루프
* while ice: 빙산 남아 있는 동안:
    * vis: 방문 배열 초기화.
    * cnt: 덩어리 수.
    * for i, j in ice: 미방문 빙산에서 DFS 호출, cnt += 1.
    * if cnt > 1: 덩어리 2개 이상 → ret = min(ret, time), 종료.
    * ice_melt: 각 빙산의 녹는 양 저장.
    * for idx, (i, j) in enumerate(ice):
        * a[i][j] = max(0, a[i][j] - ice_melt[idx]): 높이 갱신.
    * ice = [x for x in ice if a[x[0]][x[1]] != 0]: 녹지 않은 빙산 갱신.
    * time += 1: 시간 증가.
5. 출력
* ret != INF: 분리 발생 → ret 출력.
* 그 외: 모두 녹음 → 0 출력.

문제 분석
* 문제: 백준 2573 "빙산".
* 입력: N, M, N×M 격자.
* 출력: 분리 시간 (없으면 0).
* 조건: 빙산은 바다와 접촉 시 녹음, 분리는 덩어리 2개 이상.

시간 복잡도
* DFS: O(N * M) (각 칸 최대 1번 방문).
* 녹음 계산: O(N * M).
* 최대 단계: 빙산 개수 (최악 N * M).
* 총합: O(N * M * T) (T는 단계 수, N, M ≤ 300, ≈ 10^7), 1초 내 충분.
"""