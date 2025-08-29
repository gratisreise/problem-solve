from collections import deque
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]  # 상, 우, 하, 좌

def dfs(y, x, dis):
    if dis > k: return  # 거리 초과
    if y == 0 and x == c - 1 and dis < k: return  # 도착점, 거리 부족
    if y == 0 and x == c - 1 and dis == k:  # 도착점, 거리 정확
        global ret
        ret += 1 
    for d in range(4):
        ny, nx = y + dy[d], x + dx[d]
        if not (0 <= ny < r and 0 <= nx < c): continue  # 범위 밖
        if a[ny][nx] == 'T' or vis[ny][nx]: continue  # 나무 또는 방문済
        vis[ny][nx] = 1
        dfs(ny, nx, dis + 1)
        vis[ny][nx] = 0  # 백트래킹

r, c, k = map(int, input().split())  # 격자 크기, 목표 거리
a, vis = [], [[0]*c for _ in range(r)]  # 격자, 방문 배열
for i in range(r):
    a.append(list(input()))  # 격자 입력
vis[r-1][0] = 1  # 시작 위치 방문
ret = 0  # 경로 수
dfs(r-1, 0, 1)  # DFS 시작
print(ret)  # 결과 출력

"""
문제 접근 방법과 아이디어
문제 이해
* 목표: (R-1, 0)에서 (0, C-1)까지 정확히 K칸을 이동하는 경로의 수 구하기.
* 조건:
    * 격자: R×C (3 ≤ R, C ≤ 5).
    * 격자 값:
        * '.': 이동 가능.
        * 'T': 이동 불가 (나무).
    * 이동: 상하좌우.
    * 시작: (R-1, 0).
    * 도착: (0, C-1).
    * 이동 거리: 정확히 K (1 ≤ K ≤ 25).
    * 같은 칸 재방문 불가.
* 출력: 가능한 경로 수.
접근 아이디어
* DFS:
    * 시작 위치에서 모든 가능한 경로 탐색.
    * 백트래킹으로 방문 상태 관리 (재방문 방지).
    * 거리가 K이고 도착점(0, C-1)에 도달 시 카운트 증가.
* 상태 관리:
    * a: 격자 상태 ('.' 또는 'T').
    * vis: 방문 여부 배열.
    * ret: 유효 경로 수.
    * dis: 현재 이동 거리.
* 구현 전략:
    * (R-1, 0)에서 DFS 시작, 초기 거리 1.
    * 각 위치에서 4방향 탐색, 유효한 경우 이동.
    * 거리 K로 (0, C-1)에 도달 시 ret 증가.
    * 거리 초과 시 탐색 중단.
1. 입력 처리
* r, c, k: 격자 세로(R), 가로(C), 목표 거리(K).
* a: R×C 격자 입력 ('.' 또는 'T').
* vis = [[0]*c for _ in range(r)]: 방문 여부 배열.
* vis[r-1][0] = 1: 시작 위치 (R-1, 0) 방문 표시.
* ret = 0: 경로 수 초기화.
2. DFS 함수
* dfs(y, x, dis):
    * y, x: 현재 위치.
    * dis: 현재 이동 거리.
    * 종료 조건:
        * dis > k: 거리 초과 → 종료.
        * y == 0 and x == c - 1 and dis < k: 도착점, 거리 부족 → 종료.
        * y == 0 and x == c - 1 and dis == k: 도착점, 거리 정확 → ret += 1.
    * 4방향 탐색:
        * ny, nx: 다음 위치.
        * 0 <= ny < r and 0 <= nx < c: 범위 내.
        * a[ny][nx] != 'T' and not vis[ny][nx]: 나무 아님, 미방문.
        * 조건 만족 시:
            * vis[ny][nx] = 1: 방문 표시.
            * dfs(ny, nx, dis + 1): 재귀 호출.
            * vis[ny][nx] = 0: 백트래킹.
3. 실행 및 출력
* dfs(r-1, 0, 1): 시작 위치 (R-1, 0), 초기 거리 1로 DFS.
* print(ret): 유효 경로 수 출력.

문제 분석
* 문제: 백준 1189 "컴백홈".
* 입력: R, C, K, R×C 격자.
* 출력: 정확히 K칸 이동 경로 수.
* 조건: 상하좌우 이동, 재방문 불가, 나무 회피.

시간 복잡도
* 격자: R×C ≤ 25.
* 각 위치에서 4방향, 최대 K칸 이동.
* 최악: O(4^K) (K ≤ 25, 약 10^15 이론적).
* 실제: R, C ≤ 5, 나무와 방문 제약으로 경우의 수 대폭 감소, 1초 내 통과.

"""