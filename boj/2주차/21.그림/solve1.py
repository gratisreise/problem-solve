from collections import deque
dy, dx = [0, 1, 0, -1], [-1, 0, 1, 0]  # 상, 우, 하, 좌

def dfs(i, j):
    vis[i][j] = 1  # 시작점 방문
    stk = deque()
    stk.append((i, j))
    cnt = 0  # 그림 크기
    while stk:
        cnt += 1  # 현재 칸 카운트
        y, x = stk.pop()  # 현재 위치
        for d in range(4):  # 4방향 탐색
            ny, nx = y + dy[d], x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:  # 범위 체크
                continue
            if a[ny][nx] == 0 or vis[ny][nx] == 1:  # 빈 칸이거나 방문済
                continue
            vis[ny][nx] = 1  # 방문 표시
            stk.append((ny, nx))  # 다음 위치 추가
    return cnt

n, m = map(int, input().split())  # 격자 크기
a, vis = [], [[0]*m for _ in range(n)]  # 격자, 방문 배열
for _ in range(n):
    a.append(list(map(int, input().split())))  # 격자 입력

ret1, ret2 = 0, 0  # 그림 개수, 최대 그림 크기
for i in range(n):
    for j in range(m):
        if a[i][j] == 1 and vis[i][j] == 0:  # 그림이고 미방문
            ret1 += 1  # 그림 수 증가
            ret2 = max(ret2, dfs(i, j))  # 최대 크기 갱신

print(ret1, ret2, sep='\n')  # 결과 출력

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: 격자에서 그림의 개수와 가장 큰 그림의 크기(1의 개수)를 구하기.
* 조건:
    * 격자: N×M (1 ≤ N, M ≤ 500).
    * 격자 값: 0(빈 칸), 1(그림).
    * 연결: 상하좌우로 인접한 1.
* 출력:
    * 그림 개수.
    * 최대 그림 크기 (그림 없으면 0).
접근 아이디어
* DFS:
    * 각 그림(1)을 발견하면 DFS로 연결된 모든 1 탐색.
    * 탐색 중 1의 개수 세어 그림 크기 계산.
* 상태 관리:
    * a: 격자 상태.
    * vis: 방문 여부.
    * ret1: 그림 개수.
    * ret2: 최대 그림 크기.
* 구현 전략:
    * 격자 순회하며 미방문 1 발견 시 DFS 호출.
    * DFS로 그림 크기 계산, 최대값 갱신.
1. 입력 처리
* n, m: 격자 세로(N), 가로(M).
* dy, dx: 4방향 이동 벡터.
* a: N×M 격자 입력 (0: 빈 칸, 1: 그림).
* vis: N×M 방문 배열, 초기값 0.
2. DFS 함수
* dfs(i, j):
    * vis[i][j] = 1: 시작점 방문.
    * stk = deque(): 스택으로 DFS.
    * stk.append((i, j)): 시작점 추가.
    * cnt: 그림 크기(1의 개수).
    * while stk:
        * cnt += 1: 현재 칸 카운트.
        * y, x = stk.pop(): 현재 위치.
        * 4방향 탐색:
            * ny, nx: 다음 위치.
            * 범위 벗어남: 스킵.
            * 빈 칸(a[ny][nx] == 0) 또는 방문済: 스킵.
            * vis[ny][nx] = 1: 방문 표시.
            * stk.append((ny, nx)): 다음 위치 추가.
    * return cnt: 그림 크기 반환.
3. 그림 계산
* ret1, ret2 = 0, 0: 그림 개수, 최대 그림 크기.
* for i in range(n):
    * for j in range(m):
        * a[i][j] == 1 and vis[i][j] == 0: 그림이고 미방문:
            * ret1 += 1: 그림 수 증가.
            * ret2 = max(ret2, dfs(i, j)): DFS로 크기 계산, 최대값 갱신.
4. 출력
* print(ret1, ret2, sep='\n'): 그림 개수와 최대 크기 출력.

문제 분석
* 문제: 백준 1926 "그림".
* 입력: N, M, N×M 격자.
* 출력: 그림 개수, 최대 그림 크기.
* 조건: 1은 상하좌우로 연결, 크기는 1의 개수.

시간 복잡도
* 격자 순회: O(N * M).
* DFS: 각 칸 최대 1번 방문 → O(N * M).
* 총합: O(N * M) (N, M ≤ 500, ≈ 2.5×10^5), 1초 내 충분.
"""